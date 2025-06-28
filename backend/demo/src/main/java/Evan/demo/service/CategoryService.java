package Evan.demo.service;

import Evan.demo.pojo.entity.Category;
import Evan.demo.pojo.entity.Result;

import java.util.List;

public interface CategoryService {

    Result<Category> add(Category category);

    Result<List<Category>> list();

    Result<Category> updateCategory(Category category);

    Result<Category> deleteCategory(Integer id);
}
