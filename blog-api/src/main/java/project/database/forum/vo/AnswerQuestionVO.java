package project.database.forum.vo;

import lombok.Data;
import project.database.forum.dao.pojo.Answer;

/**
 * @author Yuh Z
 * @date 5/7/22
 */
@Data
public class AnswerQuestionVO extends Answer {
    private String title;
}
