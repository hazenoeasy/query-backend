package project.database.forum.vo.params;

import lombok.Data;

/**
 * @author Yuh Z
 * @date 5/6/22
 */
@Data
public class BestAnswerParams {
    private String aid;
    // 0 don;t like
    // 1 like
    private Integer operation;
}
