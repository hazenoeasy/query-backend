package project.database.forum.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import project.database.forum.dao.pojo.Question;

import java.util.List;

/**
 * @author Yuh Z
 * @date 4/30/22
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {
    List<Question> getPopularQuestion(Long number);

    List<Question> getQuestionList(Page<Question> questions, Long tid);
}
