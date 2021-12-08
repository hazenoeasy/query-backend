package plus.yuhaozhang.blog.service.struct;

import plus.yuhaozhang.blog.dao.pojo.SysUser;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
public interface SysUserService {
    /**
     * get username from table SysUser by user id
     * @param id user id
     * @return username
     */
     SysUser findUserById(Long id);

}
