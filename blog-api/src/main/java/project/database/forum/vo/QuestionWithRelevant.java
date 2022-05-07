package project.database.forum.vo;

import lombok.Data;
import project.database.forum.dao.pojo.Question;

/**
 * @author Yuh Z
 * @date 5/7/22
 */
@Data
public class QuestionWithRelevant extends Question {
    private Integer relevant;
}
