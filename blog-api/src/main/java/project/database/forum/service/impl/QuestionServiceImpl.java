package project.database.forum.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.database.forum.dao.mapper.QuestionMapper;
import project.database.forum.dao.pojo.Question;
import project.database.forum.dao.pojo.User;
import project.database.forum.service.struct.QuestionService;
import project.database.forum.vo.params.AddQuestionParams;
import project.database.forum.vo.params.QuestionListParams;

import java.util.List;

/**
 * @author Yuh Z
 * @date 4/30/22
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<Question> getPopularQuestion(Long number) {
        return questionMapper.getPopularQuestion(number);
    }

    @Override
    public List<Question> getQuestionList(QuestionListParams questionListParams) {
        Page<Question> questions = new Page<Question>(questionListParams.getPage(), questionListParams.getSize());
        return questionMapper.getQuestionList(questions, questionListParams.getTid());
    }

    @Override
    public String addQuestion(AddQuestionParams addQuestionParams, User user) {
        Question question = new Question();
        question.setBody(addQuestionParams.getBody());
        question.setTitle(addQuestionParams.getTitle());
        question.setTid(addQuestionParams.getTid());
        question.setUid(user.getUid());
        boolean save = super.save(question);
        return question.getQid();
    }
}
