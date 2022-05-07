package project.database.forum.vo;

import lombok.Data;
import project.database.forum.dao.pojo.Topic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuh Z
 * @date 5/4/22
 */
@Data
public class CascaderTopic {
    private String value;
    private String label;
    private List<CascaderTopic> children;

    public CascaderTopic(Topic topic) {
        this.value = topic.getTid();
        this.label = topic.getTopicName();
        this.children = new ArrayList<>();
    }
}
