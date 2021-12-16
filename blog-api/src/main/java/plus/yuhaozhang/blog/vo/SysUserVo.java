package plus.yuhaozhang.blog.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @author Yuh Z
 * @date 12/13/21
 */
@Data
public class SysUserVo {

    private String nickname;

    private String avatar;
    
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
}
