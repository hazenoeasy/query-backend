package project.database.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.database.forum.dao.mapper.QuestionMapper;
import project.database.forum.dao.pojo.Question;
import project.database.forum.service.struct.QuestionService;

import java.util.List;

/**
 * @author Yuh Z
 * @date 4/30/22
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<Question> getPopularQuestion(Integer number) {
        return questionMapper.getPopularQuestion(number);
    }
}
