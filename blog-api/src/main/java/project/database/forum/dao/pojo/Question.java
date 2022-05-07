package project.database.forum.dao.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @author Yuh Z
 * @date 4/26/22
 */
@Data
@TableName("Question")
public class Question {
    @TableId(type = IdType.ASSIGN_ID)
    private String qid;
    private String uid;
    private String tid;
    private String title;
    private String body;
    private Boolean resolved = false;
    private String best;
    @TableField(fill = FieldFill.INSERT)
    private Date datetime;
}
