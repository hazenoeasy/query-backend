package project.database.forum.vo.params;

import lombok.Data;

import java.util.Date;

/**
 * @author Yuh Z
 * @date 5/5/22
 */
@Data
public class AddAnswerParams {
    private String qid;
    private String text;
}
