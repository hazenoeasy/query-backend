package project.database.forum.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import project.database.forum.dao.pojo.Answer;
import project.database.forum.vo.AnswerQuestionVO;
import project.database.forum.vo.params.AnswerVO;

import java.util.List;

/**
 * @author Yuh Z
 * @date 5/1/22
 */
@Mapper
public interface AnswerMapper extends BaseMapper<Answer> {
    List<AnswerVO> answerList(String qid);

    List<AnswerQuestionVO> getAnswerListByUid(String uid);

    List<AnswerQuestionVO> searchAnswer(String keyword);
}
