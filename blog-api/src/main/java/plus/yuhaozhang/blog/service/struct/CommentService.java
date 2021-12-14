package plus.yuhaozhang.blog.service.struct;

import plus.yuhaozhang.blog.vo.CommentVo;

import java.util.List;

/**
 * @author Yuh Z
 * @date 12/13/21
 */
public interface CommentService {
    public List<CommentVo> findCommentById(Long id);
    public List<CommentVo> findCommentById(Long id, int level);
}
