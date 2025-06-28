package Evan.demo.mapper;

import Evan.demo.pojo.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {



    @Insert("INSERT INTO article (title, content, cover_img, state, category_id, create_user, create_time, update_time) " +
            "VALUES (#{title}, #{content}, #{coverImg}, #{state}, #{categoryId}, #{createUser}, #{createTime}, #{updateTime})")
    int insert(Article article);

    @Select("<script>" +
            "SELECT * FROM article " +
            "<where> " +
            "  <if test='categoryId != null'>AND category_id = #{categoryId} </if> " +
            "  <if test='state != null and state != \"\"'>AND state = #{state} </if> " +
            "</where> " +
            "ORDER BY update_time DESC" +
            "</script>")
    List<Article> pageQuery(@Param("categoryId") Integer categoryId, @Param("state") String state);

    @Update("UPDATE article SET title = #{title}, content = #{content}, cover_img = #{coverImg}, " +
            "state = #{state}, category_id = #{categoryId}, update_time = #{updateTime} " +
            "WHERE id = #{id}")
    int update(Article article);

    @Delete("DELETE FROM article WHERE id = #{id}")
    int delete(Integer id);

    @Select("SELECT * FROM article WHERE id = #{id}")
    Article getById(Integer id);
}
