package plus.yuhaozhang.blog.service.impl;

import org.springframework.stereotype.Service;
import plus.yuhaozhang.blog.dao.mapper.SysUserMapper;
import plus.yuhaozhang.blog.dao.pojo.SysUser;
import plus.yuhaozhang.blog.service.struct.SysUserService;

import javax.annotation.Resource;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
@Service
public class SysUserServiceImpl implements SysUserService {


    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserById(Long id) {

        return sysUserMapper.selectById(id);
    }
}
