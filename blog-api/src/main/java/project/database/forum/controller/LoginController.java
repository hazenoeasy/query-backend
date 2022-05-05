package project.database.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.database.forum.service.struct.LoginService;
import project.database.forum.vo.Result;
import project.database.forum.vo.params.LoginParams;

/**
 * @author Yuh Z
 * @date 12/8/21
 */
@RestController
@RequestMapping("login")
@CrossOrigin("http://localhost")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping()
    public Result login(@RequestBody LoginParams loginParams){
        return Result.success(loginService.login(loginParams));

    }
}
