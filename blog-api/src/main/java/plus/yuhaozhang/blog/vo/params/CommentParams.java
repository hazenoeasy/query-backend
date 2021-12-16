package plus.yuhaozhang.blog.vo.params;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author Yuh Z
 * @date 12/14/21
 */
@Data
public class CommentParams {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long articleId;
    private String content;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long toUserId;
}
