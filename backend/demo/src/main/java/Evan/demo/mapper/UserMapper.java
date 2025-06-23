package Evan.demo.mapper;

import Evan.demo.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(String username);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(int id);

    @Insert("INSERT INTO user(username, password, nickname, email, user_pic, create_time, update_time) " +
            "VALUES (#{username}, #{password}, #{nickname}, #{email}, #{userPic}, #{createTime}, #{updateTime})")
    int add(User user);

    @Update("UPDATE user SET username = #{username}, nickname = #{nickname}," +
            "email = #{email}, user_pic = #{userPic}, update_time = #{updateTime} Where id = #{id}" )
    boolean updateUser(User user);

    @Update("UPDATE user SET user_pic = #{avatarUrl} WHERE id = #{userId}")
    boolean updateAvatar(@Param("userId") int userId, @Param("avatarUrl") String avatarUrl);

    @Update("UPDATE user SET password = #{newPassword}, update_time = NOW() where id = #{userId}")
    int updatePassword(@Param("userId")  Integer userId, @Param("newPassword") String newPassword);
}


