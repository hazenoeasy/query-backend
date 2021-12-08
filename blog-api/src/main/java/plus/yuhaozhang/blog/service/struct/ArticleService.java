package plus.yuhaozhang.blog.service.struct;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import plus.yuhaozhang.blog.vo.ArticleVo;
import plus.yuhaozhang.blog.vo.PageParams;
import plus.yuhaozhang.blog.vo.Result;

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
}