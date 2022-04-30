package project.database.forum.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import project.database.forum.dao.pojo.Question;
import project.database.forum.dao.pojo.User;

import java.util.List;

/**
 * @author Yuh Z
 * @date 4/30/22
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {
    List<Question> getPopularQuestion(Integer number);
}
