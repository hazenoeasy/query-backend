package project.database.forum.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import project.database.forum.dao.pojo.Topic;

import java.util.List;

/**
 * @author Yuh Z
 * @date 4/30/22
 */
@Mapper
public interface TopicMapper extends BaseMapper<Topic> {
    /**
     * select popular topic based on how many question under this topic
     * @param number
     * @return
     */
    public List<Topic> getPopularTopic(Integer number);
}
