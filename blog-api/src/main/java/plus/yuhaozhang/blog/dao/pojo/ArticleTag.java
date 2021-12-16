package plus.yuhaozhang.blog.dao.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @author Yuh Z
 * @date 12/14/21
 */
@Data
public class ArticleTag {
    private Long id;
    private Long articleId;
    private Long tagId;
}
