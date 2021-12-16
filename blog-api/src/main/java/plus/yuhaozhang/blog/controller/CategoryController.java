package plus.yuhaozhang.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plus.yuhaozhang.blog.dao.pojo.Category;
import plus.yuhaozhang.blog.service.struct.CategoryService;
import plus.yuhaozhang.blog.vo.CategoryVo;
import plus.yuhaozhang.blog.vo.Result;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author Yuh Z
 * @date 12/14/21
 */
@RestController
@RequestMapping("categorys")
public class CategoryController {

    @Resource
    CategoryService categoryService;
    @GetMapping
    public Result getCategoryList(){
        List<CategoryVo> categoryList = categoryService.getCategoryList();
        return Result.success(categoryList);
    }
    @GetMapping("detail")
    public Result getCategoryDetails(){
        List<Category> categoryList = categoryService.getCategoryDetails();
        return Result.success(categoryList);
    }
    @GetMapping("detail/{id}")
    public Result getCategoryDetailById(@PathVariable("id") Long id){
        Category category = categoryService.getCategoryDetailById(id);
        return Result.success(category);
    }
}
