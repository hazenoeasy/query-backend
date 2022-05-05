package project.database.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.database.forum.service.struct.LoginService;
import project.database.forum.vo.Result;
import project.database.forum.vo.params.LoginParams;
import project.database.forum.vo.params.RegisterParams;

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
    public Result register(@RequestBody RegisterParams registerParams){
        loginService.register(registerParams);
        return Result.success(null);
    }
}
