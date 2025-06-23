package Evan.demo.service.impl;

import Evan.demo.mapper.UserMapper;
import Evan.demo.pojo.Result;
import Evan.demo.pojo.UpdatePasswordDTO;
import Evan.demo.pojo.User;
import Evan.demo.service.UserService;
//import Evan.demo.utils.PasswordUtil;
import Evan.demo.utils.JwtUtil;
import Evan.demo.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Result<String> register(String username, String password) {
        User user = userMapper.findByUsername(username);
        if(user != null){
            return Result.fail("Username already exists");
        }else{
            User newUser = new User();
            newUser.setUsername(username);
//            String encrypted = PasswordUtil.encode(password);
            newUser.setPassword(password);
            newUser.setCreateTime(LocalDateTime.now());
            newUser.setUpdateTime(LocalDateTime.now());

            userMapper.add(newUser);
            return Result.success();
        }
    }

    @Override
    public Result<String> login(String username, String password) {
        User loginUser = userMapper.findByUsername(username);
        if(loginUser == null){
            return Result.fail("wrong username");
        }else if(!loginUser.getPassword().equals(password)){
            return Result.fail("wrong password");
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", loginUser.getId());
        claims.put("username", loginUser.getUsername());

        String token = JwtUtil.genToken(claims);
        return Result.success("success",token);
    }

    @Override
    public Result<String> updateUser(User user) {
        user.setUpdateTime(LocalDateTime.now());
        boolean success = userMapper.updateUser(user);
        return success ? Result.success() : Result.fail("Update failed");
    }

    @Override
    public boolean updateAvatar(String avatarUrl){
        Integer userId = UserHolder.getUserId();
        return userMapper.updateAvatar(userId, avatarUrl);
    }

    @Override
    public Result<User> getUserInfo() {
        String username = UserHolder.getUsername();
        if (username == null) {
            return Result.fail("User not found");
        }

        User user = userMapper.findByUsername(username);
        if (user == null) {
            return Result.fail("User not found");
        }

        user.setPassword(null);
        return Result.success("Success", user);
    }

    public Result<String> updatePwd(UpdatePasswordDTO dto){
        Integer userId = UserHolder.getUserId();
        String newPassword = dto.getNewPassword();
        String oldPassword = dto.getOldPassword();
        String rePassword = dto.getRePassword();

        String currentPassword = userMapper.findById(userId).getPassword();

        if(oldPassword == null || oldPassword.trim().isEmpty()) {
            return Result.fail("please enter correct oldPassword");
        }

        if(rePassword == null || rePassword.trim().isEmpty()){
            return Result.fail("please enter correct rePassword");
        }

        if(newPassword == null || newPassword.trim().isEmpty()) {
            return Result.fail("please enter correct newPassword");
        }

        if(!newPassword.equals(rePassword)){
            return Result.fail("newPassword does not match");
        }

        if(!oldPassword.equals(currentPassword)){
            return Result.fail("oldPassword is incorrect");
        }
        int rows = userMapper.updatePassword(userId, newPassword);
        if (rows > 0) {
            return Result.success();
        } else {
            return Result.fail("Password update failed");
        }
    }
}
