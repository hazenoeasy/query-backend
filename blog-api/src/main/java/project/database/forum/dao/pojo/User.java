package project.database.forum.dao.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
@Data
@TableName("User")
public class User {
    @TableId
    private String uid;

    private String username;

    private String email;

    private String password;

    private String country;

    private String state;

    private String city;

    private Integer status;

    private String profile;

}
