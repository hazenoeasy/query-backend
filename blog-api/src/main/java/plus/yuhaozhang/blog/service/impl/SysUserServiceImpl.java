package plus.yuhaozhang.blog.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import plus.yuhaozhang.blog.dao.mapper.SysUserMapper;
import plus.yuhaozhang.blog.dao.pojo.SysUser;
import plus.yuhaozhang.blog.service.struct.SysUserService;
import plus.yuhaozhang.blog.vo.SysUserVo;

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

    @Override
    public SysUser findUserByAccount(String account) {
        return sysUserMapper.selectByAccount(account);
    }

    @Override
    public SysUserVo findUserVoById(Long id) {
        SysUser author = findUserById(id);
        if(author == null) {
            return null;
        }
        SysUserVo authorVo = new SysUserVo();
        BeanUtils.copyProperties(author,authorVo);
        return authorVo;
    }


    @Override
    public SysUser verifyUser(String account, String password) {
        SysUser user =  sysUserMapper.verifyUser(account,password);
        System.out.println(user);
        return user;
    }
}
