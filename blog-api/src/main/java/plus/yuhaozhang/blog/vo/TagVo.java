package plus.yuhaozhang.blog.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
@Data
public class TagVo {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String avatar;

    private String tagName;
}
