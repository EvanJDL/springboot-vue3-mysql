package Evan.demo.controller;

import Evan.demo.pojo.Result;
import Evan.demo.pojo.User;
import Evan.demo.service.UserService;
import Evan.demo.utils.UserHolder;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController{
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Result<String> register(
            @RequestParam
            @Pattern(regexp = "^\\S{5,16}$", message = "Username must be 5–16 non-space characters")
            String username,

            @RequestParam
            @Pattern(regexp = "^\\S{5,16}$", message = "Password must be 5–16 non-space characters")
            String password){

        return userService.register(username, password);
//        boolean success = userService.register(username,password);
//        return success ? Result.success("Registration successful",username) : Result.fail("Username already exists");
    }

    @PostMapping("/login")
    public Result<String> login(
        @RequestParam
        @Pattern(regexp = "^\\S{5,16}$", message = "Username must be 5–16 non-space characters")
        String username,

        @RequestParam
        @Pattern(regexp = "^\\S{5,16}$", message = "Password must be 5–16 non-space characters")
        String password){

        return userService.login(username, password);
    }

    @GetMapping("/userInfo")
    public Result<User> getUserInfo(){
        return userService.getUserInfo();
    }

    @PutMapping("/update")
    public Result<String> updateUserInfo(@RequestBody User user){
        return userService.updateUser(user);
//        boolean success = userService.updateUser(user);
//        return success ? Result.success(null, "Success") : Result.fail("Update failed");
    }

//    @PatchMapping("/updateAvatar")
//    public Result<String> updateAvatar(@RequestBody Map<String, String> body){
//        String avatarUrl = body.get("avatarUrl");
//        boolean success = userService.updateAvatar(avatarUrl);
//        return success ? Result.success() : Result.fail("fail");
//    }
    @PatchMapping("/updateAvatar")
    public Result<String> updateAvatar(@RequestParam String avatarUrl){
        boolean success = userService.updateAvatar(avatarUrl);
        return success ? Result.success() : Result.fail("fail");
    }



}