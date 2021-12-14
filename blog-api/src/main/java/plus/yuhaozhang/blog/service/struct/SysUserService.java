package plus.yuhaozhang.blog.service.struct;

import plus.yuhaozhang.blog.dao.pojo.SysUser;
import plus.yuhaozhang.blog.vo.SysUserVo;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
public interface SysUserService {
    /**
     * get username from table SysUser by user id
     * @param  account and password
     * @return username
     */
    SysUser verifyUser(String account, String password);
    SysUser findUserById(Long id);
    SysUser findUserByAccount(String account);
    SysUserVo findUserVoById(Long id);
}
