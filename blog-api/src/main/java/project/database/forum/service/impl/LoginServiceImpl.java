package project.database.forum.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import project.database.forum.constant.Constant;
import project.database.forum.dao.pojo.User;
import project.database.forum.handler.exception.CaughtException;
import project.database.forum.handler.exception.ExceptionEnum;
import project.database.forum.service.struct.LoginService;
import project.database.forum.service.struct.UserService;
import project.database.forum.utils.JWTUtils;
import project.database.forum.vo.params.LoginParams;
import project.database.forum.vo.params.RegisterParams;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author Yuh Z
 * @date 12/8/21
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static String salt = Constant.salt;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private project.database.forum.dao.mapper.UserMapper UserMapper;

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
        String username = loginParams.getUsername();
        String password = loginParams.getPassword();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new CaughtException(ExceptionEnum.INVALID_PARAMS);
        }

        password = DigestUtils.md5Hex(password + salt);

        User user = userService.verifyUser(username, password);
        if (user == null) {
            throw new CaughtException(ExceptionEnum.INVALID_USER);
        }
        String token = JWTUtils.createToken(user.getUid());
        redisTemplate.opsForValue().set("TOKEN_" + token, JSON.toJSONString(user), 1, TimeUnit.DAYS);
        return token;
    }
    /**
     * 1 token is null?
     * 2 token is parseable?
     * 3 token is exist?
     *
     * @param token
     * @return
     */
    @Override
    public User findUserByToken(String token) {

        if (token == null) {
            return null;
        }
        User user = checkToken(token);
        return user;
    }

    /**
     * if exist account  throw Invalid_name
     *
     * @param registerParams
     * @return
     */
    @Override
    public void register(RegisterParams registerParams) {
        if (registerParams.getUsername() == null || registerParams.getPassword() == null) {
            throw new CaughtException(ExceptionEnum.INVALID_PARAMS);
        }
        if (userService.findUserByUsername(registerParams.getUsername()) != null) {
            throw new CaughtException(ExceptionEnum.INVALID_ACCOUNT, "this username has been used");
        }
        if (userService.getOne(new QueryWrapper<User>().eq("email", registerParams.getEmail())) != null) {
            throw new CaughtException(ExceptionEnum.INVALID_ACCOUNT, "this email has been used");
        }

        User user = new User();
        user.setPassword(DigestUtils.md5Hex(registerParams.getPassword() + salt));
        user.setUsername(registerParams.getUsername());
        UserMapper.insert(user);
    }


    public User checkToken(String token) {
        String userString = redisTemplate.opsForValue().get("TOKEN_" + token);
        if (StringUtils.isBlank(userString)) {
            return null;
        }
        User user = JSON.parseObject(userString, User.class);
        return user;
    }
}

