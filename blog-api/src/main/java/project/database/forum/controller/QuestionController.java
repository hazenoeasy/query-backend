package project.database.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.database.forum.dao.pojo.Question;
import project.database.forum.service.struct.QuestionService;
import project.database.forum.vo.Result;
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
}
