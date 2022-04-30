package project.database.forum.service.struct;

import project.database.forum.dao.pojo.Question;

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
    List<Question> getPopularQuestion(Integer number);
}
