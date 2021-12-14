package plus.yuhaozhang.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plus.yuhaozhang.blog.service.struct.CommentService;
import plus.yuhaozhang.blog.vo.CommentVo;
import plus.yuhaozhang.blog.vo.Result;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yuh Z
 * @date 12/13/21
 */
@RestController
@RequestMapping("comments")
public class CommentController {

    @Resource
    private CommentService commentService;

    @GetMapping("article/{id}")
    public Result findCommentById(@PathVariable Long id){
        List<CommentVo> commentVo= commentService.findCommentById(id);
        return Result.success(commentVo);
    }
}
