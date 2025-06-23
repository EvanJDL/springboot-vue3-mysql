package Evan.demo.service.impl;

import Evan.demo.mapper.CategoryMapper;
import Evan.demo.pojo.UpdateCategoryDTO;
import Evan.demo.pojo.Category;
import Evan.demo.pojo.Result;
import Evan.demo.service.CategoryService;
import Evan.demo.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Result<Category> add(Category category) {

        category.setCreateUser(UserHolder.getUserId());
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());

        categoryMapper.insert(category);
        return Result.success();}

    @Override
    public Result<List<Category>> list() {
        int createUserId = UserHolder.getUserId();
        List<Category> list = categoryMapper.findByUserId(createUserId);
        return Result.success("success",list);
    }

    @Override
    public Result<Category> updateCategory(Category category) {
        category.setUpdateTime(LocalDateTime.now());
        int rows = categoryMapper.updateCategory(category);
        return rows > 0 ? Result.success() : Result.fail("fail");
    }

    @Override
    public Result<Category> deleteCategory(Integer id) {
        int rows = categoryMapper.deleteById(id);
        return rows>0 ? Result.success():Result.fail("fail");
    }
}
