package project.database.forum.vo.params;

import lombok.Data;

/**
 * @author Yuh Z
 * @date 5/1/22
 */
@Data
public class AddQuestionParams {
    private String title;
    private String body;
    private String topicId;
}
