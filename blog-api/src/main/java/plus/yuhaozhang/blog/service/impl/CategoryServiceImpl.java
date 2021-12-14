package plus.yuhaozhang.blog.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import plus.yuhaozhang.blog.dao.mapper.CategoryMapper;
import plus.yuhaozhang.blog.dao.pojo.Category;
import plus.yuhaozhang.blog.service.struct.CategoryService;
import plus.yuhaozhang.blog.vo.CategoryVo;

import javax.annotation.Resource;

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
}
