package project.database.forum.service.struct;

import project.database.forum.dao.pojo.Question;
import project.database.forum.vo.params.QuestionListParams;

import java.util.List;

/**
 * @author Yuh Z
 * @date 4/30/22
 */
public interface QuestionService {
    /**
     *
     * @param number
     * @return list of popular questions
     */
    List<Question> getPopularQuestion(Long number);

    List<Question> getQuestionList(QuestionListParams questionListParams);
}
