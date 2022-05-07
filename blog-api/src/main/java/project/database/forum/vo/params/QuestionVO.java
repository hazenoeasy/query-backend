package project.database.forum.vo.params;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yuh Z
 * @date 5/6/22
 */
@Data
public class QuestionVO {
    private String username;
    private String qid;
    private String uid;
    private String tid;
    private String title;
    private String body;
    private Boolean resolved;
    private String datetime;
    private String best;

    public void setDatetime(Date datetime) {
        SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.datetime = sfd.format(datetime);
    }
}
