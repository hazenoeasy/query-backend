package plus.yuhaozhang.blog.service.struct;

import plus.yuhaozhang.blog.vo.Result;
import plus.yuhaozhang.blog.vo.TagVo;

import java.util.List;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
public interface TagService {
    List<TagVo> findTagsByArticleId(Long articleId);
    public Result getHotTags(int size);
}
