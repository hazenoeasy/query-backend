package project.database.forum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.database.forum.dao.mapper.TopicMapper;
import project.database.forum.dao.pojo.Topic;
import project.database.forum.handler.exception.CaughtException;
import project.database.forum.handler.exception.ExceptionEnum;
import project.database.forum.service.struct.TopicService;
import project.database.forum.vo.CascaderTopic;
import project.database.forum.vo.params.AddTopicParams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yuh Z
 * @date 4/30/22
 */
@Service
public class TopicServiceImpl  extends ServiceImpl<TopicMapper, Topic> implements TopicService {

    @Autowired
    private TopicMapper topicMapper;
    @Override
    public List<Topic> getPopularTopic(Integer number) {
        return topicMapper.getPopularTopic(number);
    }

    @Override
    public List<Topic> getRootTopic() {
        return topicMapper.getRootTopic();
    }

    @Override
    public List<Topic> getChildTopic(String parentId) {
        return topicMapper.getChildTopic(parentId);
    }

    @Override
    public String addNewTopic(AddTopicParams addTopicParams) {
        QueryWrapper<Topic> topicQueryWrapper = new QueryWrapper<>();
        topicQueryWrapper.eq("topic_name",addTopicParams.getTopicName());
        Topic topic = this.getOne(topicQueryWrapper);
        if(topic!=null){
            throw new CaughtException(ExceptionEnum.INVALID_PARAMS,"this topic name has been used");
        }
        else{
            Topic topic1 = new Topic();
            topic1.setTopicName(addTopicParams.getTopicName());
            topic1.setText(addTopicParams.getText());
            topic1.setParentId(addTopicParams.getParentId());
            this.save(topic1);
            return topic1.getTid();
        }
    }

    @Override
    public List<CascaderTopic> getCascaderTopics() {
        List<Topic> list = this.list();
        Map<String,CascaderTopic> mapper = new HashMap<>(50);
        List<CascaderTopic> result = new ArrayList<>();
        // build tid --> Topic mapper
        for (Topic topic : list) {
            CascaderTopic cascaderTopic = new CascaderTopic(topic);
            mapper.put(topic.getTid(), cascaderTopic);
        }
        // loop the list ;add children
        for (Topic topic : list) {
            if (topic.getTid().equals(topic.getParentId())) {
                CascaderTopic cascaderTopic = mapper.get(topic.getTid());
                result.add(cascaderTopic);
            } else {
                CascaderTopic parentTopic = mapper.get(topic.getParentId());
                CascaderTopic cascaderTopic = mapper.get(topic.getTid());
                parentTopic.getChildren().add(cascaderTopic);
            }
        }
        return result;
    }
}
