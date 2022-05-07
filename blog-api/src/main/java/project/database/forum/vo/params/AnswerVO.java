package project.database.forum.vo.params;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yuh Z
 * @date 5/6/22
 */
@Data
public class AnswerVO{
    private String username;
    private String aid;
    private String qid;
    private String uid;
    private String text;
    private Integer likes;
    private Boolean best;
    private String datetime;
    public void setDatetime(Date datetime){
        SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.datetime = sfd.format(datetime);
    }
}
