package plus.yuhaozhang.blog.service.struct;

import org.springframework.transaction.annotation.Transactional;
import plus.yuhaozhang.blog.dao.pojo.SysUser;
import plus.yuhaozhang.blog.vo.params.LoginParams;

@Transactional(rollbackFor=Exception.class)
/**
 * @author Yuh Z
 * @date 12/8/21
 */

public interface LoginService {
    String login(LoginParams loginParams);
    SysUser findUserByToken(String token);
    void register(LoginParams loginParams);
}
