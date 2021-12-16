package plus.yuhaozhang.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import plus.yuhaozhang.blog.dao.mapper.CategoryMapper;
import plus.yuhaozhang.blog.dao.pojo.Category;
import plus.yuhaozhang.blog.service.struct.CategoryService;
import plus.yuhaozhang.blog.vo.CategoryVo;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuh Z
 * @date 12/12/21
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public CategoryVo findCategoryById(Long id) {
        //return null;
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(categoryMapper.selectById(id),categoryVo);
        return categoryVo;
    }

    @Override
    public List<CategoryVo> getCategoryList() {
        LambdaQueryWrapper<Category> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        List<Category> categories = categoryMapper.selectList(lambdaQueryWrapper);
        return copyCategory(categories);
    }

    @Override
    public List<Category> getCategoryDetails() {
        return  categoryMapper.selectList(new LambdaQueryWrapper<Category>());
    }

    @Override
    public Category getCategoryDetailById(Long id) {
        return categoryMapper.selectById(id);
    }

    public List<CategoryVo> copyCategory(List<Category> categories){
        List<CategoryVo> categoryVos = new ArrayList<>();
        for(Category category:categories){
            CategoryVo categoryVo = new CategoryVo();
            BeanUtils.copyProperties(category,categoryVo);
            categoryVos.add(categoryVo);
        }
        return categoryVos;
    }
}
