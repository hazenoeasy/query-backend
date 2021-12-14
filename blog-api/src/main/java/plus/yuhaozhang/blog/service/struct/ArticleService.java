package plus.yuhaozhang.blog.service.struct;

import plus.yuhaozhang.blog.dao.dos.Archives;
import plus.yuhaozhang.blog.vo.ArticleVo;
import plus.yuhaozhang.blog.vo.HotArticleVo;
import plus.yuhaozhang.blog.vo.params.PageParams;

import java.util.List;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
public interface ArticleService {
    /**
     * get article list
     * @param pageParams
     * @return
     */
    public List<ArticleVo> listArticle(PageParams pageParams);

    public List<HotArticleVo> getHotArticles();

    public List<HotArticleVo> getNewArticles();

    public List<Archives> getListArchives();

    public ArticleVo findArticleById(Long articleId);
}
