package project.database.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.database.forum.dao.mapper.AnswerMapper;
import project.database.forum.dao.pojo.Answer;
import project.database.forum.dao.pojo.User;
import project.database.forum.handler.exception.CaughtException;
import project.database.forum.handler.exception.ExceptionEnum;
import project.database.forum.service.struct.AnswerService;
import project.database.forum.service.struct.LoginService;
import project.database.forum.vo.AnswerQuestionVO;
import project.database.forum.vo.Result;
import project.database.forum.vo.params.AddAnswerParams;
import project.database.forum.vo.params.AnswerVO;
import project.database.forum.vo.params.BestAnswerParams;
import project.database.forum.vo.params.LikeAnswerParams;

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
        List<AnswerVO> list = answerService.getAnswerList(qid);
        return Result.success(list);
    }

    @PostMapping("reply")
    public Result addAnswer(@RequestBody AddAnswerParams addAnswerParams, @RequestHeader("Authorization") String token) {
        User user = loginService.findUserByToken(token);
        String aid = answerService.addAnswer(addAnswerParams, user);
        return Result.success(aid);
    }

    @PostMapping("like")
    public Result likeAnswer(@RequestBody LikeAnswerParams likeAnswerParams, @RequestHeader("Authorization") String token) {
        User user = loginService.findUserByToken(token);
        if(user == null){
            throw new CaughtException(ExceptionEnum.INVALID_TOKEN);
        }
        answerService.likeAnswer(likeAnswerParams, user);
        return Result.success(true);
    }

    @PostMapping("best")
    public Result bestAnswer(@RequestBody BestAnswerParams bestAnswerParams, @RequestHeader("Authorization") String token) {
        User user = loginService.findUserByToken(token);
        answerService.bestAnswer(bestAnswerParams, user);
        return Result.success(true);
    }

    @GetMapping("user")
    public Result gerAnswerListByUid(@RequestParam String uid) {

        List<AnswerQuestionVO> list = answerService.gerAnswerListByUid(uid);
        return Result.success(list);
    }

    @GetMapping("search")
    public Result searchAnswer(@RequestParam String keyword){
        List<AnswerQuestionVO> list =answerService.searchAnswer(keyword);
        return Result.success(list);
    }
}
