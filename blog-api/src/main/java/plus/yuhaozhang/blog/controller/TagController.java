package plus.yuhaozhang.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plus.yuhaozhang.blog.dao.mapper.TagMapper;
import plus.yuhaozhang.blog.dao.pojo.Tag;
import plus.yuhaozhang.blog.service.struct.TagService;
import plus.yuhaozhang.blog.vo.Result;
import plus.yuhaozhang.blog.vo.TagVo;

import java.util.List;

/**
 * @author Yuh Z
 * @date 12/8/21
 */
@RestController
@RequestMapping("tags")
public class TagController {
    private static int  HOT_NUMBER = 6;
    @Autowired
    private TagService tagService;

    @GetMapping("hot")
    public Result getHotTags(){
        List<Tag> tags = tagService.getHotTags(HOT_NUMBER);
       return Result.success(tags);
    }
    @GetMapping
    public Result getTagList(){
        List<TagVo> tags = tagService.getTagList();
        return Result.success(tags);
    }
    @GetMapping("detail")
    public Result getTagDetails(){
        List<Tag> tags = tagService.getTagDetail();
        return Result.success(tags);
    }

}
