package plus.yuhaozhang.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plus.yuhaozhang.blog.vo.PageParams;
import plus.yuhaozhang.blog.vo.Result;
import plus.yuhaozhang.blog.service.struct.ArticleService;

/**
 * @author Yuh Z
 * @date 12/7/21
 */
@RestController
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    /**
     * 首页文章列表
     * @param pageParams
     * @return
     */
    @PostMapping
    public Result listArticle(@RequestBody PageParams pageParams){
        System.out.println("xxxx");
        System.out.println(pageParams);
        return articleService.listArticle(pageParams);
    }
}
