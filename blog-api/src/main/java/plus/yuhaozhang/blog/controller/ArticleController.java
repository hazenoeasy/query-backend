package plus.yuhaozhang.blog.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import plus.yuhaozhang.blog.vo.params.ArticleParam;
import plus.yuhaozhang.blog.vo.params.PageParams;
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
        return Result.success(articleService.listArticle(pageParams));
    }

    @GetMapping("hot")
    public Result getHotArticles(){
        return Result.success(articleService.getHotArticles());
    }

    @GetMapping("new")
    public Result getNewArticles(){
        return Result.success(articleService.getNewArticles());
    }

    @GetMapping("listArchives")
    public Result getListArchives(){
        return Result.success(articleService.getListArchives());
    }

    @GetMapping("view/{id}")
    public Result findArticleById(@PathVariable("id") Long articleId){
        return Result.success(articleService.findArticleById(articleId));
    }
    @PostMapping("publish")
    public Result publishArticle(@RequestBody ArticleParam articleParam){
        Long id = articleService.publishArticle(articleParam);
        System.out.println(id);
        return Result.success(id+"");
    }

}
