package project.database.forum.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.database.forum.dao.pojo.Answer;
import project.database.forum.service.struct.AnswerService;
import project.database.forum.vo.Result;

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

    @GetMapping("list")
    public Result getAnswerList(@RequestParam String qid) {
        QueryWrapper<Answer> answerQueryWrapper = new QueryWrapper<>();
        answerQueryWrapper.eq("qid", qid);
        List<Answer> list = answerService.list(answerQueryWrapper);
        return Result.success(list);
    }

}
