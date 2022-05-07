package project.database.forum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.database.forum.dao.mapper.AnswerMapper;
import project.database.forum.dao.mapper.QuestionMapper;
import project.database.forum.dao.mapper.UserLikeMapper;
import project.database.forum.dao.pojo.Answer;
import project.database.forum.dao.pojo.Question;
import project.database.forum.dao.pojo.User;
import project.database.forum.dao.pojo.UserLike;
import project.database.forum.handler.exception.CaughtException;
import project.database.forum.handler.exception.ExceptionEnum;
import project.database.forum.service.struct.AnswerService;
import project.database.forum.service.struct.QuestionService;
import project.database.forum.vo.params.AddAnswerParams;
import project.database.forum.vo.params.AnswerVO;
import project.database.forum.vo.params.BestAnswerParams;
import project.database.forum.vo.params.LikeAnswerParams;

import java.util.List;

/**
 * @author Yuh Z
 * @date 5/1/22
 */
@Service
public class AnswerServiceImpl extends ServiceImpl<AnswerMapper, Answer> implements AnswerService {
    @Autowired
    private UserLikeMapper userLikeMapper;
    @Autowired
    private QuestionService questionService;
    @Autowired AnswerMapper answerMapper;
    @Override
    public String addAnswer(AddAnswerParams addAnswerParams, User user) {
        Answer answer = new Answer();
        answer.setQid(addAnswerParams.getQid());
        answer.setText(addAnswerParams.getText());
        answer.setUid(user.getUid());
        boolean save = this.save(answer);
        if(!save){
            throw new CaughtException(ExceptionEnum.SYSTEM_FAIL,"save data failed");
        }else{
            return answer.getAid();
        }
    }

    /**
     * step1 根据aid uid找record
     * step2 要是没找到 就创建新的record
     * step3 要是找到了 就更新like值
     * step4 根据变化量 更新Answer like 数量
     * @param likeAnswerParams
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void likeAnswer(LikeAnswerParams likeAnswerParams, User user){

        UserLike userLike =userLikeMapper.getUserLikeRecord(likeAnswerParams.getAid(),user.getUid());

        int diff =0;
        // step2
        if(userLike==null){
            UserLike userLike1 = new UserLike();
            userLike1.setLikes(likeAnswerParams.getLikes());
            userLike1.setUid(user.getUid());
            userLike1.setAid(likeAnswerParams.getAid());
            userLikeMapper.insert(userLike1);
            diff = likeAnswerParams.getLikes();
        }else{
            //step3
            Integer like = userLike.getLikes();
            diff = likeAnswerParams.getLikes()-like;
            userLike.setLikes(likeAnswerParams.getLikes());
            userLikeMapper.updateById(userLike);
        }
        // step4
        Answer answer = this.getById(likeAnswerParams.getAid());
        answer.setLikes(answer.getLikes()+diff);
        this.updateById(answer);
    }

    /**
     * step1 根据aid 找qid
     * step2 查找qid 下有无best answer
     * step3 要是有 则返回异常
     * step4 要是没有 判断qid 的uid 和 user是否一致 设置best 为 true
     * @param bestAnswerParams
     * @param user
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void bestAnswer(BestAnswerParams bestAnswerParams, User user) {
        Answer answer = this.getById(bestAnswerParams.getAid());
        Question question = questionService.getById(answer.getQid());
        Answer answer1 = this.getOne(new QueryWrapper<Answer>().eq("best", 1));
        Integer operation = bestAnswerParams.getOperation();
        // 取消best answer
        if(operation==0){
            if(answer1!=null && answer1.getBest()){
                answer1.setBest(false);
                question.setBest("");
                this.updateById(answer1);
                questionService.updateById(question);
            }
            return;
        }
        // 设置best answer
        if(operation==1){
            if(answer1==null || answer1.getBest()==false){
                answer.setBest(true);
                question.setBest(bestAnswerParams.getAid());
                questionService.updateById(question);
                this.updateById(answer);

            }
            return;
        }
        throw  new CaughtException(ExceptionEnum.INVALID_PARAMS);
    }

    @Override
    public List<AnswerVO> getAnswerList(String qid) {
        List<AnswerVO> list = answerMapper.answerList(qid);
        return list;
    }
}
