package project.database.forum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.database.forum.dao.pojo.Answer;
import project.database.forum.dao.pojo.User;
import project.database.forum.service.struct.AnswerService;
import project.database.forum.service.struct.LoginService;
import project.database.forum.vo.Result;
import project.database.forum.vo.params.AddAnswerParams;

import java.util.List;

/**
 * @author Yuh Z
 * @date 5/1/22
 */
@RestController
@RequestMapping("answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private LoginService loginService;
    @GetMapping("list")
    public Result getAnswerList(@RequestParam String qid) {
        QueryWrapper<Answer> answerQueryWrapper = new QueryWrapper<>();
        answerQueryWrapper.eq("qid", qid);
        List<Answer> list = answerService.list(answerQueryWrapper);
        return Result.success(list);
    }

    @PostMapping("reply")
    public Result addAnswer(@RequestBody AddAnswerParams addAnswerParams,@RequestHeader("Authorization") String token){
        User user = loginService.findUserByToken(token);
        String aid = answerService.addAnswer(addAnswerParams,user);
        return Result.success(aid);
    }

}
