package plus.yuhaozhang.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import plus.yuhaozhang.blog.service.struct.LoginService;
import plus.yuhaozhang.blog.vo.Result;
import plus.yuhaozhang.blog.vo.params.LoginParams;

/**
 * @author Yuh Z
 * @date 12/8/21
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result login(@RequestBody LoginParams loginParams){
        return Result.success(loginService.login(loginParams));

    }
}
