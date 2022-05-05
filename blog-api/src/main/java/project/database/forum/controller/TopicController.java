package project.database.forum.controller;

import net.sf.jsqlparser.statement.select.Top;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.database.forum.dao.pojo.Question;
import project.database.forum.dao.pojo.Topic;
import project.database.forum.service.struct.QuestionService;
import project.database.forum.service.struct.TopicService;
import project.database.forum.vo.CascaderTopic;
import project.database.forum.vo.Result;
import project.database.forum.vo.params.AddTopicParams;

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
    public Result getChildTopic(@RequestParam("parentId") String parentId){
        List<Topic> list = topicService.getChildTopic(parentId);
        return Result.success(list);
    }

    @GetMapping("detail")
    public Result getTopicById(@RequestParam("tid") String tid) {
        Topic topic = topicService.getById(tid);
        return Result.success(topic);
    }

    @PostMapping("newTopic")
    public Result addNewTopic(AddTopicParams addTopicParams){
        String tid = topicService.addNewTopic(addTopicParams);
        return Result.success(tid);
    }
    @GetMapping("cascader")
    public Result getCascaderTopics(){
        List<CascaderTopic> list = topicService.getCascaderTopics();
        return Result.success(list);
    }
}
