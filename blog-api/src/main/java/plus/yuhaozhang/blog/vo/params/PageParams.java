package plus.yuhaozhang.blog.vo.params;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
@NoArgsConstructor
@Data
public class PageParams {
    private Integer page =1;
    private Integer pageSize = 10;
    private Long categoryId;
    private Long tagId;
    private String year;

    public String getMonth() {
        if(this.month !=null && this.month.length() ==1){
            return "0"+month;
        }
        return month;
    }

    private String month;
}
