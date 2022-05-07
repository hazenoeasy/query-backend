package project.database.forum.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.database.forum.dao.mapper.QuestionMapper;
import project.database.forum.dao.pojo.Question;
import project.database.forum.dao.pojo.User;
import project.database.forum.handler.exception.CaughtException;
import project.database.forum.handler.exception.ExceptionEnum;
import project.database.forum.service.struct.QuestionService;
import project.database.forum.vo.params.AddQuestionParams;
import project.database.forum.vo.params.QuestionID;
import project.database.forum.vo.params.QuestionListParams;
import project.database.forum.vo.params.QuestionVO;

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
        List<Question> popularQuestion = questionMapper.getPopularQuestion(number);
        return popularQuestion;
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

    @Override
    public QuestionVO getQuestionById(String qid) {
        Question question = this.getById(qid);
        QuestionVO questionVO = new QuestionVO();
        questionVO.setBody(question.getBody());
        questionVO.setTitle(question.getTitle());
        questionVO.setTid(question.getTid());
        questionVO.setUid(question.getUid());
        questionVO.setDatetime(question.getDatetime());
        questionVO.setQid(question.getQid());
        questionVO.setResolved(question.getResolved());
        questionVO.setBest(question.getBest());
        return questionVO;
    }

    /**
     * step 1
     *
     * @param qid
     * @param user
     */
    @Override
    public void resolveQuestion(QuestionID qid, User user) {
        Question question = this.getById(qid.getQid());
        if (question == null) {
            throw new CaughtException(ExceptionEnum.INVALID_PARAMS);
        }
        if (!question.getUid().equals(user.getUid())) {
            throw new CaughtException(ExceptionEnum.INVALID_ACCOUNT);
        }
        question.setResolved(true);
        this.updateById(question);
    }

    @Override
    public void cancelResolveQuestion(QuestionID qid, User user) {
        Question question = this.getById(qid.getQid());
        if (question == null) {
            throw new CaughtException(ExceptionEnum.INVALID_PARAMS);
        }
        if (!question.getUid().equals(user.getUid())) {
            throw new CaughtException(ExceptionEnum.INVALID_ACCOUNT);
        }
        question.setResolved(false);
        this.updateById(question);
    }

    @Override
    public List<QuestionVO> getQuestionListByUid(String uid) {
        List<QuestionVO> list = questionMapper.getQuestionListByUid(uid);
        return list;
    }
}
