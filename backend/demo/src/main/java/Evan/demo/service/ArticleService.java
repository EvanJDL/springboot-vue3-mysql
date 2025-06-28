package Evan.demo.service;

import Evan.demo.pojo.dto.ArticlePageQueryDTO;
import Evan.demo.pojo.entity.Article;
import Evan.demo.pojo.entity.PageResult;
import Evan.demo.pojo.entity.Result;

public interface ArticleService {
    Result<Article> insert(Article article);

    Result<PageResult<Article>> pageQuery(ArticlePageQueryDTO dto);

    Result<Article> update(Article article);

    Result<Article> delete(Integer id);

    Result<Article> getById(Integer id);
}


