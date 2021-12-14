package plus.yuhaozhang.blog.controller;

/**
 * @author Yuh Z
 * @date 12/9/21
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plus.yuhaozhang.blog.dao.pojo.SysUser;
import plus.yuhaozhang.blog.handler.exception.CaughtException;
import plus.yuhaozhang.blog.handler.exception.ExceptionEnum;
import plus.yuhaozhang.blog.service.struct.LoginService;
import plus.yuhaozhang.blog.vo.Result;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private LoginService loginService;

    @GetMapping("currentUser")
    public Result currentUser(@RequestHeader("Authorization") String token){
        SysUser sysUser= loginService.findUserByToken(token);
        if(sysUser==null) {
            throw new CaughtException(ExceptionEnum.INVALID_TOKEN);
        }
        return Result.success(loginService.findUserByToken(token));
    }
}
