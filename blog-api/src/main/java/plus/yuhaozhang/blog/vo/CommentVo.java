package plus.yuhaozhang.blog.vo;

import lombok.Data;
import plus.yuhaozhang.blog.dao.pojo.SysUser;

import java.util.List;

/**
 * @author Yuh Z
 * @date 12/13/21
 */
@Data
public class CommentVo {

    private Long id;

    private SysUserVo author;

    private String content;

    private List<CommentVo> children;

    private String createDate;

    private Integer level;

    private SysUserVo toUser;

}
