package project.database.forum.dao.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author Yuh Z
 * @date 4/26/22
 */
@Data
public class Question {
    private String qid;
    private String uid;
    private String title;
    private String body;
    private Boolean resolved;
    private Date datetime;
}
