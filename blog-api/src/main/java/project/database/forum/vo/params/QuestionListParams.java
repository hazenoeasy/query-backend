package project.database.forum.vo.params;

import lombok.Data;

/**
 * @author Yuh Z
 * @date 4/30/22
 */
@Data
public class QuestionListParams {
    private Integer page;
    private Integer size;
    private Long tid;
}
