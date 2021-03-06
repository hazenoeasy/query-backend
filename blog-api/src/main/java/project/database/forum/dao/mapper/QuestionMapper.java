package project.database.forum.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import project.database.forum.dao.pojo.Question;
import project.database.forum.vo.QuestionWithRelevant;
import project.database.forum.vo.params.QuestionVO;

import java.util.List;

/**
 * @author Yuh Z
 * @date 4/30/22
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {
    List<Question> getPopularQuestion(Long number);

    List<Question> getQuestionList(Page<Question> questions, Long tid);

    List<QuestionVO> getQuestionListByUid(String uid);

    List<QuestionWithRelevant> searchQuestion(String keyword);
}
