package plus.yuhaozhang.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import plus.yuhaozhang.blog.dao.pojo.Tag;

import java.util.List;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
public interface TagMapper extends BaseMapper<Tag> {
    /**
     *  find Tags by Articled ID
     * @param articleId article id
     * @return tags list
     */
    List<Tag> findTagsByArticleId(Long articleId);
}
