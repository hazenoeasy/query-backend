package project.database.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import project.database.forum.dao.mapper.UserMapper;
import project.database.forum.dao.pojo.User;
import project.database.forum.service.struct.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {

        return userMapper.selectByUsername(username);
    }

    @Override
    public User verifyUser(String account, String password) {
        User user = userMapper.verifyUser(account, password);
        System.out.println(user);
        return user;
    }

    @Override
    public List<User> getUserList() {
        return userMapper.selectList(null);
    }
}
