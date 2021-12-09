package plus.yuhaozhang.blog.service.impl;

import io.netty.util.internal.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plus.yuhaozhang.blog.handler.CaughtException;
import plus.yuhaozhang.blog.handler.ExceptionEnum;
import plus.yuhaozhang.blog.service.struct.LoginService;
import plus.yuhaozhang.blog.service.struct.SysUserService;
import plus.yuhaozhang.blog.vo.params.LoginParams;

/**
 * @author Yuh Z
 * @date 12/8/21
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 1. Check loginParam if is legal
     * 2. Query Table ms_sys_user
     * 3. fail return
     * 4. success return token
     * save token in redis
     * @param loginParams
     * @return
     */
    @Override
    public String login(LoginParams loginParams) {
        String account = loginParams.getAccount();
        String password = loginParams.getPassword();
        if(StringUtils.isBlank(account) || StringUtils.isBlank(password)){
            throw new CaughtException(ExceptionEnum.INVALID_PARAMS);
            //throw new CaughtException(ExceptionEnum.INVALID_PARAMS,"自定义");
        }

        return null;

    }
}
