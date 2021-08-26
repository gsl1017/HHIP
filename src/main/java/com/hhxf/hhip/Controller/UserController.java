package com.hhxf.hhip.Controller;

import com.hhxf.hhip.Model.User;
import com.hhxf.hhip.Service.UserService;
import com.hhxf.hhip.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

//    @GetMapping("/updateUser/{id}")
//    public Result updateUser(@PathVariable("id") String id){
//        User user=userService.getUserById(id);
//        return userService.save(user);
//    }
    @GetMapping("/queryall")
    public Result queryAll(){
        Result cc=userService.queryAll();
        return cc;
    }
    @PostMapping("/save")//RequestBody 获取对象参数
    public Result saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/login")//RequestParam 获取查询参数
    public Result Login(@RequestBody User user){
        return userService.Login(user.getAccount(),user.getPwd());
    }

    @GetMapping("/get/{id}")//PathVariable 获取路径参数
    public Result get(@PathVariable String id){
        return userService.getById(id);
    }
}
