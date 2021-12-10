package plus.yuhaozhang.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import plus.yuhaozhang.blog.dao.pojo.SysUser;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    SysUser verifyUser(String account, String hash);
    SysUser selectByAccount(String account);

}
