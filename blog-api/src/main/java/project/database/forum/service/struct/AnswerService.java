package project.database.forum.service.struct;

import com.baomidou.mybatisplus.extension.service.IService;
import project.database.forum.dao.pojo.Answer;
import project.database.forum.dao.pojo.Question;
import project.database.forum.dao.pojo.User;
import project.database.forum.vo.params.AddAnswerParams;
import project.database.forum.vo.params.BestAnswerParams;
import project.database.forum.vo.params.LikeAnswerParams;

/**
 * @author Yuh Z
 * @date 5/1/22
 */
public interface AnswerService extends IService<Answer> {
    String addAnswer(AddAnswerParams addAnswerParams, User user);
    void likeAnswer(LikeAnswerParams likeAnswerParams, User user);

    void bestAnswer(BestAnswerParams bestAnswerParams, User user);
}
