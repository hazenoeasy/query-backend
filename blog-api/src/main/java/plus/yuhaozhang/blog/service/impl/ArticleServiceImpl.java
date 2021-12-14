package plus.yuhaozhang.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import plus.yuhaozhang.blog.dao.dos.Archives;
import plus.yuhaozhang.blog.dao.mapper.ArticleMapper;
import plus.yuhaozhang.blog.dao.mapper.ArticleBodyMapper;
import plus.yuhaozhang.blog.dao.pojo.Article;
import plus.yuhaozhang.blog.dao.pojo.ArticleBody;
import plus.yuhaozhang.blog.dao.pojo.SysUser;
import plus.yuhaozhang.blog.handler.exception.CaughtException;
import plus.yuhaozhang.blog.handler.exception.ExceptionEnum;
import plus.yuhaozhang.blog.service.struct.*;
import plus.yuhaozhang.blog.vo.*;
import plus.yuhaozhang.blog.vo.params.PageParams;

import javax.annotation.Resource;
import javax.smartcardio.CardException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    private static final String UNKNOW_USER = "unknownUser";
    private static final Integer HOT_ARTICLES = 10;
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
    /**
     * 分页查询数据库
     * @param pageParams 传入数据
     * @return
     */
    @Override
    public List<ArticleVo> listArticle(PageParams pageParams){
        Page<Article> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getWeight).orderByDesc(Article::getCreateDate);
        Page<Article> articlePage = articleMapper.selectPage(page,queryWrapper);
        List<Article> records = articlePage.getRecords();
        if(records.size()==0){
            throw new CaughtException(ExceptionEnum.INVALID_PARAMS);
        }
        List<ArticleVo>  articleVos = copyList(records,true,true,false,false);
        return articleVos;
    }

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
        if(article == null) {
            throw  new CaughtException(ExceptionEnum.INVALID_PARAMS);
        }
        ArticleVo articleVo = copy(article,true,true,true,true);
        articleVo.setId(article.getId());
        threadService.updateArticleViewCount(articleMapper,article);
        return articleVo;
    }

    private List<ArticleVo> copyList(List<Article> records, boolean isTag, boolean isAuthor, boolean isBody,boolean isCategory){
      List<ArticleVo> vos= new ArrayList<>();
      for(Article e: records){
          vos.add(copy(e,isTag,isAuthor,isBody,isCategory));
      }
      return vos;
    }
    private ArticleVo copy(Article article,boolean isTag, boolean isAuthor,boolean isBody,boolean isCategory){
        ArticleVo vo = new ArticleVo();
        BeanUtils.copyProperties(article,vo);
        vo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        if(isTag){
            List<TagVo> vos = tagService.findTagsByArticleId(article.getId());
            vo.setTags(vos);
        }
        if(isAuthor){
            String username;
            SysUser sysUser = sysUserService.findUserById(article.getAuthorId());
            if(sysUser == null) {
                username = UNKNOW_USER;
            } else {
                username = sysUser.getNickname();
            }
            vo.setAuthor(username);
        }
        if (isBody){
            Long bodyId = article.getBodyId();
            vo.setBody(findArticleBodyById(bodyId));
        }
        if (isCategory){
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
