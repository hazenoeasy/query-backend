package project.database.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import project.database.forum.dao.mapper.AnswerMapper;
import project.database.forum.dao.pojo.Answer;
import project.database.forum.dao.pojo.User;
import project.database.forum.handler.exception.CaughtException;
import project.database.forum.handler.exception.ExceptionEnum;
import project.database.forum.service.struct.AnswerService;
import project.database.forum.vo.params.AddAnswerParams;

/**
 * @author Yuh Z
 * @date 5/1/22
 */
@Service
public class AnswerServiceImpl extends ServiceImpl<AnswerMapper, Answer> implements AnswerService {
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
}
