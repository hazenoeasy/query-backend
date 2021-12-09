package plus.yuhaozhang.blog.service.impl;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import plus.yuhaozhang.blog.constant.Constant;
import plus.yuhaozhang.blog.dao.pojo.SysUser;
import plus.yuhaozhang.blog.handler.CaughtException;
import plus.yuhaozhang.blog.handler.ExceptionEnum;
import plus.yuhaozhang.blog.service.struct.LoginService;
import plus.yuhaozhang.blog.service.struct.SysUserService;
import plus.yuhaozhang.blog.utils.JWTUtils;
import plus.yuhaozhang.blog.vo.params.LoginParams;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Yuh Z
 * @date 12/8/21
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static String salt = Constant.salt;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    /**
     * 1. Check loginParam if is legal
     * 2. Query Table ms_sys_user
     * 3. fail return
     * 4. success return token
     * save token in redis
     *
     * @param loginParams
     * @return
     */
    @Override
    public String login(LoginParams loginParams) {
        String account = loginParams.getAccount();
        String password = loginParams.getPassword();
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            throw new CaughtException(ExceptionEnum.INVALID_PARAMS);
        }
        password = DigestUtils.md5Hex(password + salt);
        SysUser user = sysUserService.verifyUser(account, password);
        if (user == null) {
            throw new CaughtException(ExceptionEnum.INVALID_USER);
        }
        String token = JWTUtils.createToken(user.getId());
        redisTemplate.opsForValue().set("TOKEN_" + token, JSON.toJSONString(user), 1, TimeUnit.DAYS);
        return token;
    }

    /**
     * 1 token is null?
     * 2 token is parseable?
     * 3 token is exist?
     * @param token
     * @return
     */
    @Override
    public SysUser findUserByToken(String token) {
        if(token == null ){
           return null;
        }
        SysUser user = checkToken(token);
        return user;
    }
    public SysUser checkToken(String token){
        String userString =redisTemplate.opsForValue().get("TOKEN_"+token);
        if(StringUtils.isBlank(userString)) {
            return null;
        }
        SysUser user = JSON.parseObject(userString,SysUser.class);
        return user;
    }
}

