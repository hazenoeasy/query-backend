package project.database.forum.dao.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Yuh Z
 * @date 5/6/22
 */
@Data
@TableName(value = "UserLike")
public class UserLike {
    @TableId
    private String rid;
    private String uid;
    private String aid;
    private Integer like;
}
