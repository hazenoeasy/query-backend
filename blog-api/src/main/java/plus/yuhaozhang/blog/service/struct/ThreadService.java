package plus.yuhaozhang.blog.service.struct;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import plus.yuhaozhang.blog.dao.mapper.ArticleMapper;
import plus.yuhaozhang.blog.dao.pojo.Article;

/**
 * @author Yuh Z
 * @date 12/13/21
 */
@Component
public class ThreadService {
    @Async("taskExecutor")
    public void updateArticleViewCount(ArticleMapper mapper, Article article){
        int viewCounts = article.getViewCounts();
        Article newArticle = new Article();
        newArticle.setViewCounts(viewCounts+1);
        LambdaUpdateWrapper<Article> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Article::getId,article.getId());
        updateWrapper.eq(Article::getViewCounts,article.getViewCounts());
        mapper.update(newArticle,updateWrapper);
    }
}
