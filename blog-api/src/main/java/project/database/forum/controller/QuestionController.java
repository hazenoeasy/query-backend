package project.database.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.database.forum.dao.pojo.Question;
import project.database.forum.dao.pojo.User;
import project.database.forum.service.struct.LoginService;
import project.database.forum.service.struct.QuestionService;
import project.database.forum.service.struct.UserService;
import project.database.forum.vo.QuestionWithRelevant;
import project.database.forum.vo.Result;
import project.database.forum.vo.UserVO;
import project.database.forum.vo.params.AddQuestionParams;
import project.database.forum.vo.params.QuestionID;
import project.database.forum.vo.params.QuestionListParams;
import project.database.forum.vo.params.QuestionVO;

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

    @Autowired
    private UserService userService;

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
        QuestionVO question = questionService.getQuestionById(qid);
        UserVO user = userService.getUserById(question.getUid());
        question.setUsername(user.getUsername());
        return Result.success(question);
    }

    @PostMapping("resolve")
    public Result resolveQuestion(@RequestBody QuestionID qid, @RequestHeader("Authorization") String token) {
        User user = loginService.findUserByToken(token);
        questionService.resolveQuestion(qid, user);
        return Result.success(true);
    }

    @PostMapping("cancelResolve")
    public Result cancelResolveQuestion(@RequestBody QuestionID qid, @RequestHeader("Authorization") String token) {
        User user = loginService.findUserByToken(token);
        questionService.cancelResolveQuestion(qid, user);
        return Result.success(true);
    }
    @GetMapping("user")
    public Result getQuestionListByUid(String uid){
        List<QuestionVO> list = questionService.getQuestionListByUid(uid);
        return Result.success(list);
    }

    /**
     * return a list of question with order by relevant.
     * If the keywords match the title of the question, the weight is 3, otherwise is 0
     * If the keywords match the body of the question, the weight is 2, otherwise is 0
     * If the keywords match anyone's answer, the weight is 1. if there are multiple matches
     * @param keyword
     * @return
     */
    @GetMapping("search")
    public Result searchQuestion(@RequestParam String keyword){
        List<QuestionWithRelevant> list = questionService.searchQuestion(keyword);
        return Result.success(list);
    }

}
