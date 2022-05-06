package project.database.forum.vo.params;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import project.database.forum.dao.pojo.Question;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yuh Z
 * @date 5/6/22
 */
@Data
public class QuestionVO  {
    private String username;
    private String qid;
    private String uid;
    private String tid;
    private String title;
    private String body;
    private Boolean resolved;
    private String datetime;
    public void setDatetime(Date datetime){
        SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.datetime = sfd.format(datetime);
    }
}
