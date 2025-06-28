package Evan.demo.service;

import Evan.demo.pojo.entity.Result;
import Evan.demo.pojo.dto.UpdatePasswordDTO;
import Evan.demo.pojo.entity.User;

public interface UserService{
    Result<String> register(String username, String password);

    Result<String> login(String username, String password);

    Result<String> updateUser(User user);

    boolean updateAvatar(String avatarUrl);

    Result<User> getUserInfo();

    Result<String> updatePwd(UpdatePasswordDTO dto);
}


