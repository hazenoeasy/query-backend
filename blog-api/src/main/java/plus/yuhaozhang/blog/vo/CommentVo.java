package plus.yuhaozhang.blog.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import plus.yuhaozhang.blog.dao.pojo.SysUser;

import java.util.List;

/**
 * @author Yuh Z
 * @date 12/13/21
 */
@Data
public class CommentVo {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private SysUserVo author;

    private String content;

    private List<CommentVo> children;

    private String createDate;

    private Integer level;

    private SysUserVo toUser;

}
