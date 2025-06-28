package Evan.demo.service.impl;

import Evan.demo.mapper.ArticleMapper;
import Evan.demo.pojo.dto.ArticlePageQueryDTO;
import Evan.demo.pojo.entity.Article;
import Evan.demo.pojo.entity.PageResult;
import Evan.demo.pojo.entity.Result;
import Evan.demo.service.ArticleService;
import Evan.demo.utils.UserHolder;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Result<Article> insert(Article article) {
        article.setCreateUser(UserHolder.getUserId());
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        return articleMapper.insert(article) > 0
                ? Result.success()
                : Result.fail("fail");
    }

    @Override
    public Result<PageResult<Article>> pageQuery(ArticlePageQueryDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        List<Article> list = articleMapper.pageQuery(dto.getCategoryId(), dto.getState());
        PageInfo<Article> pageInfo = new PageInfo<>(list);

        PageResult<Article> pageResult = new PageResult<>(
                pageInfo.getTotal(),
                pageInfo.getList()
        );
        return Result.success("success", pageResult);
    }

    @Override
    public Result<Article> update(Article article) {
        article.setCreateUser(UserHolder.getUserId());
        article.setUpdateTime(LocalDateTime.now());
        return articleMapper.update(article) > 0
                ? Result.success()
                : Result.fail("fail");
    }

    @Override
    public Result<Article> delete(Integer id) {
        return articleMapper.delete(id) > 0
                ? Result.success()
                : Result.fail("fail");
    }

    @Override
    public Result<Article> getById(Integer id) {
        Article article = articleMapper.getById(id);
        return article !=null
                ? Result.success("success",article)
                : Result.fail("fail");
    }
}
