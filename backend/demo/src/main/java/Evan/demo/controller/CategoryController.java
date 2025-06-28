package Evan.demo.controller;

import Evan.demo.pojo.entity.Category;
import Evan.demo.pojo.entity.Result;
import Evan.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private  CategoryService categoryService;
    @PostMapping
    public Result<Category> addCategory(@RequestBody @Validated Category category){

        return categoryService.add(category);
    }

    @GetMapping
    public Result<List<Category>> listCategories(){
        return categoryService.list();
    }

    @PutMapping("/detail")
    public Result<Category> updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping
    public Result<Category> deleteCategory(@RequestParam Integer id) {
        return categoryService.deleteCategory(id);
    }
}
