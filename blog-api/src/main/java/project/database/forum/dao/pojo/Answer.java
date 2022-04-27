package project.database.forum.dao.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author Yuh Z
 * @date 4/26/22
 */
@Data
public class Answer {
    private String qid;
    private String aid;
    private String uid;
    private String text;
    private Integer likes;
    private Boolean best;
    private Date datetime;
}
