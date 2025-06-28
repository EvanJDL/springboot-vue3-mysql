package Evan.demo.controller;

import Evan.demo.pojo.dto.ArticlePageQueryDTO;
import Evan.demo.pojo.entity.Article;
import Evan.demo.pojo.entity.PageResult;
import Evan.demo.pojo.entity.Result;
import Evan.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result<Article> insert(@RequestBody Article article) {
        return articleService.insert(article);
    }

    @GetMapping("/list")
    public Result<PageResult<Article>> getAll(ArticlePageQueryDTO dto ) {
       return  articleService.pageQuery(dto);
    }

    @PutMapping
    public Result<Article> update(@RequestBody Article article) {
        return articleService.update(article);
    }

    @DeleteMapping("/{id}")
    public Result<Article> delete(@PathVariable Integer id) {
        return articleService.delete(id);
    }

    @GetMapping("/detail/{id}")
    public Result<Article> getById(@PathVariable Integer id) {
        return articleService.getById(id);
    }

}
