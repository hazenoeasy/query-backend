package project.database.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.database.forum.dao.mapper.TopicMapper;
import project.database.forum.dao.pojo.Topic;
import project.database.forum.service.struct.TopicService;

import java.util.List;

/**
 * @author Yuh Z
 * @date 4/30/22
 */
@Service
public class TopicServiceImpl implements TopicService {

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
    public List<Topic> getChildTopic(Integer parentId) {
        return topicMapper.getChildTopic(parentId);
    }
}
