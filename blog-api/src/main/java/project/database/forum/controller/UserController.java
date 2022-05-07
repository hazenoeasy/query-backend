package project.database.forum.controller;

/**
 * @author Yuh Z
 * @date 12/9/21
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.database.forum.dao.pojo.User;
import project.database.forum.handler.exception.CaughtException;
import project.database.forum.handler.exception.ExceptionEnum;
import project.database.forum.service.struct.LoginService;
import project.database.forum.service.struct.UserService;
import project.database.forum.vo.Result;
import project.database.forum.vo.UserVO;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @GetMapping("currentUser")
    public Result currentUser(@RequestHeader("Authorization") String token) {
        User user = loginService.findUserByToken(token);
        if (user == null) {
            throw new CaughtException(ExceptionEnum.INVALID_TOKEN);
        }
        return Result.success(user);
    }

    @GetMapping("userList")
    public Result userList() {
        List<User> userList = userService.getUserList();
        return Result.success(userList);
    }

    @GetMapping("one")
    public Result getUserById(@RequestParam String uid) {
        UserVO userVO = userService.getUserById(uid);
        return Result.success(userVO);
    }
}
