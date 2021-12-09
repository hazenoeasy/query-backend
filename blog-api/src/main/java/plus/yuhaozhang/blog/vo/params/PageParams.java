package plus.yuhaozhang.blog.vo.params;

import lombok.Data;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
@Data
public class PageParams {
    private Integer page =1;
    private Integer pageSize = 10;
}
