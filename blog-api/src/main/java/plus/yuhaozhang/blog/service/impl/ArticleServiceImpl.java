package plus.yuhaozhang.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import plus.yuhaozhang.blog.dao.dos.Archives;
import plus.yuhaozhang.blog.dao.mapper.ArticleBodyMapper;
import plus.yuhaozhang.blog.dao.mapper.ArticleMapper;
import plus.yuhaozhang.blog.dao.mapper.ArticleTagMapper;
import plus.yuhaozhang.blog.dao.pojo.Article;
import plus.yuhaozhang.blog.dao.pojo.ArticleBody;
import plus.yuhaozhang.blog.dao.pojo.ArticleTag;
import plus.yuhaozhang.blog.dao.pojo.SysUser;
import plus.yuhaozhang.blog.handler.exception.CaughtException;
import plus.yuhaozhang.blog.handler.exception.ExceptionEnum;
import plus.yuhaozhang.blog.service.struct.*;
import plus.yuhaozhang.blog.utils.UserThreadLocal;
import plus.yuhaozhang.blog.vo.ArticleBodyVo;
import plus.yuhaozhang.blog.vo.ArticleVo;
import plus.yuhaozhang.blog.vo.HotArticleVo;
import plus.yuhaozhang.blog.vo.TagVo;
import plus.yuhaozhang.blog.vo.params.ArticleParam;
import plus.yuhaozhang.blog.vo.params.PageParams;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    private static final String UNKNOW_USER = "unknownUser";
    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private ArticleBodyMapper articleContentMapper;

    @Resource
    private TagService tagService;

    @Resource
    private SysUserService sysUserService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private ThreadService threadService;

    @Resource
    private ArticleTagMapper articleTagMapper;

    @Resource
    private ArticleBodyMapper articleBodyMapper;

    /**
     * 分页查询数据库
     *
     * @param pageParams 传入数据
     * @return
     */
    @Override
    public List<ArticleVo> listArticle(PageParams pageParams) {
        Page<Article> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        IPage<Article> articleList = articleMapper.getArticleList(page, pageParams.getCategoryId(), pageParams.getTagId(),
                pageParams.getYear(), pageParams.getMonth());
        List<Article> records = articleList.getRecords();
        return copyList(records,true,true,false,false);
    }
    //@Override
    //public List<ArticleVo> listArticle(PageParams pageParams) {
    //    Page<Article> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
    //    LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
    //    if(pageParams.getCategoryId()!=null){
    //        queryWrapper.eq(Article::getCategoryId,pageParams.getCategoryId());
    //    }
    //    if(pageParams.getTagId()!=null){
    //        List<ArticleTag> articleTags = articleTagMapper.selectList(new LambdaQueryWrapper<ArticleTag>().eq(ArticleTag::getId, pageParams.getTagId()));
    //        List<Long> articleIds = articleTags.stream().map(e->e.getArticleId()).collect(Collectors.toList());
    //        queryWrapper.in(Article::getId,articleIds);
    //    }
    //    queryWrapper.orderByDesc(Article::getWeight).orderByDesc(Article::getCreateDate);
    //    Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
    //    List<Article> records = articlePage.getRecords();
    //    if (records.size() == 0) {
    //        //throw new CaughtException(ExceptionEnum.INVALID_PARAMS);
    //        return null;
    //    }
    //    return copyList(records, true, true, false, false);
    //}

    @Override
    public List<HotArticleVo> getHotArticles() {
        return articleMapper.getHotArticles(10);
    }

    @Override
    public List<HotArticleVo> getNewArticles() {
        return articleMapper.getNewArticles(10);
    }

    @Override
    public List<Archives> getListArchives() {
        return articleMapper.getListArchives();
    }

    @Override
    public ArticleVo findArticleById(Long articleId) {
        Article article = this.articleMapper.selectById(articleId);
        if (article == null) {
            throw new CaughtException(ExceptionEnum.INVALID_PARAMS);
        }
        ArticleVo articleVo = copy(article, true, true, true, true);
        articleVo.setId(article.getId());
        threadService.updateArticleViewCount(articleMapper, article);
        return articleVo;
    }

    /**
     * 1 save body
     * 2 save category id
     * 3 save author id
     * view count 0
     * save tag id
     *
     * @param articleParam
     * @return ArticleId
     */
    @Override
    public Long publishArticle(ArticleParam articleParam) {
        SysUser sysUser = UserThreadLocal.get();
        // insert article
        Article article = new Article();
        article.setCreateDate(System.currentTimeMillis());
        article.setAuthorId(sysUser.getId());
        article.setCategoryId(articleParam.getCategory().getId());
        article.setSummary(articleParam.getSummary() == null ? "" : articleParam.getSummary());
        article.setTitle(articleParam.getTitle());
        article.setWeight(0);
        article.setViewCounts(0);
        article.setCommentCounts(0);
        articleMapper.insert(article);

        //insert articleBody
        ArticleBody articleBody = new ArticleBody();
        articleBody.setArticleId(article.getId());
        articleBody.setContent(articleParam.getBody().getContent() == null ? "" : articleParam.getBody().getContent());
        articleBody.setContentHtml(articleParam.getBody().getContentHtml() == null ? "" : articleParam.getBody().getContentHtml());
        articleBodyMapper.insert(articleBody);
        article.setBodyId(articleBody.getId());
        //update body_id
        articleMapper.updateById(article);
        //insert Tag
        for (TagVo tagVo : articleParam.getTags()) {
            ArticleTag tag = new ArticleTag();
            tag.setArticleId(article.getId());
            tag.setTagId(tagVo.getId());
            articleTagMapper.insert(tag);
        }

        return article.getId();
    }

    private List<ArticleVo> copyList(List<Article> records, boolean isTag, boolean isAuthor, boolean isBody, boolean isCategory) {
        List<ArticleVo> vos = new ArrayList<>();
        for (Article e : records) {
            vos.add(copy(e, isTag, isAuthor, isBody, isCategory));
        }
        return vos;
    }

    private ArticleVo copy(Article article, boolean isTag, boolean isAuthor, boolean isBody, boolean isCategory) {
        ArticleVo vo = new ArticleVo();
        BeanUtils.copyProperties(article, vo);
        vo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        if (isTag) {
            List<TagVo> vos = tagService.findTagsByArticleId(article.getId());
            vo.setTags(vos);
        }
        if (isAuthor) {
            String username;
            SysUser sysUser = sysUserService.findUserById(article.getAuthorId());
            if (sysUser == null) {
                username = UNKNOW_USER;
            } else {
                username = sysUser.getNickname();
            }
            vo.setAuthor(username);
        }
        if (isBody) {
            Long bodyId = article.getBodyId();
            vo.setBody(findArticleBodyById(bodyId));
        }
        if (isCategory) {
            Long categoryId = article.getCategoryId();
            vo.setCategory(categoryService.findCategoryById(categoryId));
        }
        return vo;
    }

    private ArticleBodyVo findArticleBodyById(Long bodyId) {
        ArticleBody articleBody = articleContentMapper.selectById(bodyId);
        ArticleBodyVo articleBodyVo = new ArticleBodyVo();
        articleBodyVo.setContent(articleBody.getContent());
        return articleBodyVo;
    }
}
