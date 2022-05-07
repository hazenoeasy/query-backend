package project.database.forum.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Yuh Z
 * @date 5/5/22
 */
@Data
@TableName("userview")
public class UserView {
    @TableId
    private String uid;

    private String username;

    private String email;

    private String password;

    private String country;

    private String state;

    private String city;

    private String status;

    private String profile;

}
