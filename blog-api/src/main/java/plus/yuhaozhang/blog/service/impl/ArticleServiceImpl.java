package plus.yuhaozhang.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import plus.yuhaozhang.blog.dao.dos.Archives;
import plus.yuhaozhang.blog.dao.mapper.ArticleMapper;
import plus.yuhaozhang.blog.dao.pojo.Article;
import plus.yuhaozhang.blog.dao.pojo.SysUser;
import plus.yuhaozhang.blog.service.struct.ArticleService;
import plus.yuhaozhang.blog.service.struct.SysUserService;
import plus.yuhaozhang.blog.service.struct.TagService;
import plus.yuhaozhang.blog.vo.*;
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
    private static final Integer HOT_ARTICLES = 10;
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private TagService tagService;

    @Resource
    private SysUserService sysUserService;
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
        List<ArticleVo>  articleVos = copyList(records,true,true);
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

    private List<ArticleVo> copyList(List<Article> records, boolean isTag, boolean isAuthor){
      List<ArticleVo> vos= new ArrayList<>();
      for(Article e: records){
          vos.add(copy(e,isTag,isAuthor));
      }
      return vos;
    }
    private ArticleVo copy(Article article,boolean isTag, boolean isAuthor){
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
        return vo;
    }
}
