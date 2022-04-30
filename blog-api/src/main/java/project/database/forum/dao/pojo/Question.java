package project.database.forum.dao.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Yuh Z
 * @date 4/26/22
 */
@Data
@TableName("Question")
public class Question {
    @TableId
    private String qid;
    private String uid;
    private String title;
    private String body;
    private Boolean resolved;
    private Date datetime;
}
