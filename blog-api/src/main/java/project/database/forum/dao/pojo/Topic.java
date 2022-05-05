package project.database.forum.dao.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Yuh Z
 * @date 4/26/22
 */
@Data
@TableName("Topic")
public class Topic {
    @TableId
    private String tid;
    @TableField(value = "parentId")
    private String parentId;
    @TableField(value = "topic_name")
    private String topicName;
    private String text;
}
