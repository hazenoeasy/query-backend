package project.database.forum.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import project.database.forum.dao.pojo.UserLike;

/**
 * @author Yuh Z
 * @date 5/6/22
 */
@Mapper
public interface UserLikeMapper extends BaseMapper<UserLike> {
    UserLike getUserLikeRecord(String aid, String uid);
}
