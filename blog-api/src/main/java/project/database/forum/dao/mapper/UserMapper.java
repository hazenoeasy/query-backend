package project.database.forum.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import project.database.forum.dao.pojo.User;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User verifyUser(String account, String hash);

    User selectByUsername(String username);

}
