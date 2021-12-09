package plus.yuhaozhang.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import plus.yuhaozhang.blog.dao.dos.Archives;
import plus.yuhaozhang.blog.dao.pojo.Article;
import plus.yuhaozhang.blog.vo.HotArticleVo;

import java.util.List;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
public interface ArticleMapper extends BaseMapper<Article> {
    List<HotArticleVo> getHotArticles(int size);
    List<HotArticleVo> getNewArticles(int size);
    List<Archives> getListArchives();
}
