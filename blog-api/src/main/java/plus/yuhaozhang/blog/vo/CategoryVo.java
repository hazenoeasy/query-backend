package plus.yuhaozhang.blog.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author Yuh Z
 * @date 12/12/21
 */
@Data
public class CategoryVo {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String avatar;
    private String categoryName;
}
