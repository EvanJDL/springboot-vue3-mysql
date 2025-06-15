package Evan.demo.mapper;

import Evan.demo.pojo.Result;
import Evan.demo.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{username}")
    public User findByUsername(String username);

    @Insert("INSERT INTO user(username, password, nickname, email, user_pic, create_time, update_time) " +
            "VALUES (#{username}, #{password}, #{nickname}, #{email}, #{userPic}, #{createTime}, #{updateTime})")
    public int add(User user);

    @Update("UPDATE user SET username = #{username}, password = #{password}, nickname = #{nickname}," +
            "email = #{email}, user_pic = #{userPic}, update_time = #{updateTime} Where id = #{id}" )
    public boolean updateUser(User user);

    @Update("UPDATE user SET user_pic = #{avatarUrl} WHERE id = #{userId}")
    boolean updateAvatar(@Param("userId") int userId, @Param("avatarUrl") String avatarUrl);
}


