package plus.yuhaozhang.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plus.yuhaozhang.blog.service.struct.LoginService;
import plus.yuhaozhang.blog.vo.Result;
import plus.yuhaozhang.blog.vo.params.LoginParams;

/**
 * @author Yuh Z
 * @date 12/9/21
 */
@RestController
@RequestMapping("register")
public class RegisterController {
    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result register(@RequestBody LoginParams loginParams){
        loginService.register(loginParams);
        return Result.success(null);
    }
}
