package project.database.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import project.database.forum.dao.mapper.AnswerMapper;
import project.database.forum.dao.pojo.Answer;
import project.database.forum.service.struct.AnswerService;

/**
 * @author Yuh Z
 * @date 5/1/22
 */
@Service
public class AnswerServiceImpl extends ServiceImpl<AnswerMapper, Answer> implements AnswerService {
}
