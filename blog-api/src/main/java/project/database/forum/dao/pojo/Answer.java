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
@TableName("Answer")
public class Answer {
    @TableId
    private String aid;
    private String qid;
    private String uid;
    private String text;
    private Integer likes;
    private Boolean best;
    private Date datetime;
}
