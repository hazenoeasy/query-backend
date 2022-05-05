package project.database.forum.vo.params;

import lombok.Data;

/**
 * @author Yuh Z
 * @date 5/4/22
 */
@Data
public class AddTopicParams {
    private String parentId;
    private String topicName;
    private String text;
}
