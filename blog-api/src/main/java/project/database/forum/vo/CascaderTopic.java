package project.database.forum.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
    private String tid;
    private String parentId;
    private String topicName;
    private String text;
    private List<CascaderTopic> children;

    public CascaderTopic(Topic topic) {
        this.tid = topic.getTid();
        this.parentId = topic.getParentId();
        this.topicName = topic.getTopicName();
        this.text = topic.getText();
        this.children = new ArrayList<>();
    }
}
