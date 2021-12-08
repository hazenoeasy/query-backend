package plus.yuhaozhang.blog.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plus.yuhaozhang.blog.dao.mapper.TagMapper;
import plus.yuhaozhang.blog.dao.pojo.Tag;
import plus.yuhaozhang.blog.service.struct.TagService;
import plus.yuhaozhang.blog.vo.Result;
import plus.yuhaozhang.blog.vo.TagVo;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
@Service
public class TagServiceImpl implements TagService {
    @Resource
    private TagMapper tagMapper;

    @Override
    public List<TagVo> findTagsByArticleId(Long articleId) {
        //MybatisPlus无法多表查询
        List<Tag> tags =  tagMapper.findTagsByArticleId(articleId);
        return copylist(tags);
    }

    @Override
    public List<Tag> getHotTags(int size) {
        List<Long> tags = tagMapper.getHotTagsId(size);
        List<Tag> result = tagMapper.getTagsNameById(tags);
        return result;
    }

    private List<TagVo> copylist(List<Tag> tags){
        List<TagVo> vo = new ArrayList<>();
        for(Tag tag: tags){
            vo.add(copyTag(tag));
        }
        return vo;
    }
    private TagVo copyTag(Tag tag){
        TagVo result=new TagVo();
        BeanUtils.copyProperties(tag,result);
        return result;
    }
}
