package Evan.demo.mapper;

import Evan.demo.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Insert("INSERT INTO category (category_name, category_alias, create_user, create_time, update_time) " +
            "VALUES (#{categoryName},#{categoryAlias},#{createUser}, #{createTime}, #{updateTime})")
    void insert(Category category);

    @Select("SELECT * FROM CATEGORY WHERE create_user = #{createUserId}")
    List<Category> findByUserId(int createUserId);


    @Update("UPDATE category SET category_name = #{categoryName}, category_alias = #{categoryAlias},"+
            " update_time = #{updateTime} WHERE id = #{id}")
    int updateCategory(Category category);

    @Delete("DELETE FROM category WHERE id = #{id}")
    int deleteById(Integer id);
}
