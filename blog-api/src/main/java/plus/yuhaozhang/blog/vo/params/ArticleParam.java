package plus.yuhaozhang.blog.vo.params;

import lombok.Data;
import plus.yuhaozhang.blog.vo.CategoryVo;
import plus.yuhaozhang.blog.vo.TagVo;

import java.util.List;

/**
 * @author Yuh Z
 * @date 12/14/21
 */
@Data
public class ArticleParam {
    private Long id;
    private ArticleBodyParam body;
    private CategoryVo category;
    private String summary;
    private List<TagVo> tags;
    private String title;
}
