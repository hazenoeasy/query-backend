package plus.yuhaozhang.blog.service.struct;

import plus.yuhaozhang.blog.dao.pojo.Category;
import plus.yuhaozhang.blog.vo.CategoryVo;

import java.util.List;

/**
 * @author Yuh Z
 * @date 12/12/21
 */
public interface CategoryService {
    public CategoryVo findCategoryById(Long id);
    List<CategoryVo> getCategoryList();
    List<Category> getCategoryDetails();
}
