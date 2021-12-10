package plus.yuhaozhang.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plus.yuhaozhang.blog.service.struct.LogoutService;
import plus.yuhaozhang.blog.vo.Result;

/**
 * @author Yuh Z
 * @date 12/9/21
 */
@RestController
@RequestMapping("logout")
public class LogoutController {
    @Autowired
    private LogoutService logoutService;
    @GetMapping
    public Result logout(@RequestHeader("Authorization") String token){
        logoutService.logout(token);
        return Result.success("succeed!");
    }
}
