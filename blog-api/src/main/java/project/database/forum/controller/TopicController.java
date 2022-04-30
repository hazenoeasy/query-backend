package project.database.forum.controller;

import net.sf.jsqlparser.statement.select.Top;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.database.forum.dao.pojo.Question;
import project.database.forum.dao.pojo.Topic;
import project.database.forum.service.struct.QuestionService;
import project.database.forum.service.struct.TopicService;
import project.database.forum.vo.Result;

import java.util.List;

/**
 * @author Yuh Z
 * @date 4/30/22
 */
@RestController
@RequestMapping("topic")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("popular")
    public Result PopularQuestion(@RequestParam("number") Integer number) {
        List<Topic> list = topicService.getPopularTopic(number);
        return Result.success(list);
    }

    @GetMapping("rootTopic")
    public Result getRootTopic() {
        List<Topic> list = topicService.getRootTopic();
        return Result.success(list);
    }

    @GetMapping("childTopic")
    public Result getChildTopic(@RequestParam("parentId") Integer parentId){
        List<Topic> list = topicService.getChildTopic(parentId);
        return Result.success(list);
    }
}
