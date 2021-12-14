package plus.yuhaozhang.blog.dao.pojo;

import lombok.Data;

/**
 * @author Yuh Z
 * @date 12/12/21
 */
@Data
public class ArticleBody {
    private Long id;
    private String content;
    private String contentHtml;
    private Long articleId;
}
