package project.database.forum.service.struct;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import project.database.forum.dao.pojo.Topic;

import java.util.List;

/**
 * @author Yuh Z
 * @date 4/30/22
 */
public interface TopicService extends IService<Topic> {
    List<Topic> getPopularTopic(Integer number);

    List<Topic> getRootTopic();

    List<Topic> getChildTopic(String parentId);
}
