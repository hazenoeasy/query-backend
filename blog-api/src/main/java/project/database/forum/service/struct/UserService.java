package project.database.forum.service.struct;

import project.database.forum.dao.pojo.User;

import java.util.List;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
public interface UserService {
    /**
     * get username from table User by user id
     *
     * @param account and password
     * @return username
     */
    User verifyUser(String account, String password);

    User findUserByUsername(String username);

    List<User> getUserList();
}
