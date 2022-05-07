package project.database.forum.service.struct;

import org.springframework.transaction.annotation.Transactional;
import project.database.forum.dao.pojo.User;
import project.database.forum.vo.params.LoginParams;
import project.database.forum.vo.params.RegisterParams;

@Transactional(rollbackFor = Exception.class)
/**
 * @author Yuh Z
 * @date 12/8/21
 */

public interface LoginService {
    String login(LoginParams loginParams);

    User findUserByToken(String token);

    void register(RegisterParams registerParams);
}
