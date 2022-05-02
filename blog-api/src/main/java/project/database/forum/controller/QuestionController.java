package project.database.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.database.forum.dao.pojo.Question;
import project.database.forum.dao.pojo.User;
import project.database.forum.service.struct.LoginService;
import project.database.forum.service.struct.QuestionService;
import project.database.forum.vo.Result;
import project.database.forum.vo.params.AddQuestionParams;
import project.database.forum.vo.params.QuestionListParams;

import java.util.List;

/**
 * @author Yuh Z
 * @date 4/30/22
 */
@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private LoginService loginService;

    @GetMapping("popular")
    public Result PopularQuestion(@RequestParam("number") Long number) {
        List<Question> list = questionService.getPopularQuestion(number);
        return Result.success(list);
    }

    @GetMapping("list")
    public Result getQuestionList(QuestionListParams questionListParams) {
        List<Question> list = questionService.getQuestionList(questionListParams);
        return Result.success(list);
    }

    @PostMapping("new")
    public Result addQuestion(@RequestBody AddQuestionParams addQuestionParams, @RequestHeader("Authorization") String token) {
        // need to verify user in the future
        User user = loginService.findUserByToken(token);
        String s = questionService.addQuestion(addQuestionParams, user);
        return Result.success(s);
    }

    @GetMapping("detail")
    public Result getQuestionById(@RequestParam String qid) {
        Question question = questionService.getById(qid);
        return Result.success(question);
    }
}
