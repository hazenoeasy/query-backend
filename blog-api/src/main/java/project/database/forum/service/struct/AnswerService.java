package project.database.forum.service.struct;

import com.baomidou.mybatisplus.extension.service.IService;
import project.database.forum.dao.pojo.Answer;
import project.database.forum.dao.pojo.User;
import project.database.forum.vo.AnswerQuestionVO;
import project.database.forum.vo.params.AddAnswerParams;
import project.database.forum.vo.params.AnswerVO;
import project.database.forum.vo.params.BestAnswerParams;
import project.database.forum.vo.params.LikeAnswerParams;

import java.util.List;

/**
 * @author Yuh Z
 * @date 5/1/22
 */
public interface AnswerService extends IService<Answer> {
    String addAnswer(AddAnswerParams addAnswerParams, User user);

    void likeAnswer(LikeAnswerParams likeAnswerParams, User user);

    void bestAnswer(BestAnswerParams bestAnswerParams, User user);

    List<AnswerVO> getAnswerList(String qid);

    List<AnswerQuestionVO> gerAnswerListByUid(String uid);

    List<AnswerQuestionVO> searchAnswer(String keyword);
}
