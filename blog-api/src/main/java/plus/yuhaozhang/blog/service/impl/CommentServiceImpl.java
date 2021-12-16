package plus.yuhaozhang.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import plus.yuhaozhang.blog.dao.mapper.CommentMapper;
import plus.yuhaozhang.blog.dao.pojo.Comment;
import plus.yuhaozhang.blog.dao.pojo.SysUser;
import plus.yuhaozhang.blog.service.struct.CommentService;
import plus.yuhaozhang.blog.service.struct.SysUserService;
import plus.yuhaozhang.blog.utils.UserThreadLocal;
import plus.yuhaozhang.blog.vo.CommentVo;
import plus.yuhaozhang.blog.vo.params.CommentParams;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuh Z
 * @date 12/13/21
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Resource
    private SysUserService sysUserService;

    @Override
    public List<CommentVo> findCommentById(Long id) {
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getArticleId, id);
        queryWrapper.eq(Comment::getLevel, 1);
        List<Comment> comments = commentMapper.selectList(queryWrapper);
        return copyComment(comments, 1);
    }

    @Override
    public List<CommentVo> findCommentById(Long id, int level) {
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        if(level ==1) {
            queryWrapper.eq(Comment::getArticleId, id);
        } else {
            queryWrapper.eq(Comment::getParentId, id);
        }
        queryWrapper.eq(Comment::getLevel, level);
        List<Comment> comments = commentMapper.selectList(queryWrapper);
        return copyComment(comments, 2);
    }

    @Override
    public void publishComment(CommentParams commentParams) {
        SysUser sysUser = UserThreadLocal.get();
        Comment comment = new Comment();
        comment.setCreateDate(System.currentTimeMillis());
        comment.setContent(commentParams.getContent());
        comment.setArticleId(commentParams.getArticleId());
        comment.setAuthorId(sysUser.getId());
        comment.setLevel((commentParams.getParentId()==null || commentParams.getParentId()==0)?1:2);
        comment.setParentId(commentParams.getParentId()==null?0:commentParams.getParentId());
        comment.setToUid(commentParams.getToUserId()==null?0:commentParams.getToUserId());
        commentMapper.insert(comment);
    }

    public List<CommentVo> copyComment(List<Comment> comments, int level) {
        List<CommentVo> commentVoList = new ArrayList<>();
        for (Comment comment : comments) {
            CommentVo commentVo = new CommentVo();
            BeanUtils.copyProperties(comment, commentVo);
            commentVo.setAuthor(sysUserService.findUserVoById(comment.getAuthorId()));
            commentVo.setCreateDate(new DateTime(comment.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
            if (level == 1) {
                commentVo.setChildren(findCommentById(comment.getId(), 2));
            }
            if(level == 2) {
                commentVo.setToUser(sysUserService.findUserVoById(comment.getToUid()));
            }
            commentVoList.add(commentVo);
        }
        return commentVoList;
    }
}
