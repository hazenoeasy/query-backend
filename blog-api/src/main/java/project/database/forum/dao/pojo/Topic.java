package project.database.forum.dao.pojo;

import lombok.Data;

/**
 * @author Yuh Z
 * @date 4/26/22
 */
@Data
public class Topic {
    private String tid;
    private String parentId;
    private String topicName;
    private String text;
}
