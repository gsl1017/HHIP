package com.hhxf.hhip.Controller;

import com.hhxf.hhip.eas.EASLoginProxy;
import com.hhxf.hhip.eas.EASLoginProxyServiceLocator;
import com.hhxf.hhip.eas.EASLoginSoapBindingStub;
import com.hhxf.hhip.eas.WSContext;
import com.hhxf.hhip.Model.User;
import com.hhxf.hhip.Service.UserService;
import com.hhxf.hhip.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.URL;
import java.rmi.RemoteException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
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

    @GetMapping("/queryuser")
    public Result queryOracleUser(){
        return userService.queryOracleUser();
    }

    @PostMapping("/save")//RequestBody 获取对象参数
    public Result saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/login")//RequestParam 获取查询参数
    public Result Login(@RequestBody User user ){
        try {
            EASLoginProxyServiceLocator locator = new EASLoginProxyServiceLocator();
            WSContext ctx = locator.getEASLogin().login(user.getAccount(), user.getPwd(), "eas",
                    "0001", "l2", 2);
            if (ctx != null && ctx.getSessionId() != null) {
                user=userService.getByAccount(user.getAccount());
            }
        } catch (Exception e) {
            throw new RuntimeException("登录 eas 失败！");
        }
        return new Result(user);
    }

    @GetMapping("/get/{id}")//PathVariable 获取路径参数
    public Result get(@PathVariable String id){
        return userService.getById(id);
    }
}
