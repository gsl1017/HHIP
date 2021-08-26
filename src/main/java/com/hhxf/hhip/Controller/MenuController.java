package com.hhxf.hhip.Controller;

import com.hhxf.hhip.Service.MenuService;
import com.hhxf.hhip.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping("/getMlistByU/{id}")//PathVariable 获取路径参数
    public Result getMlistByU(@PathVariable String id){
        System.out.println(id);
        return menuService.getListByuserid(id);
    }

    @GetMapping("/queryall")
    public Result queryAll(){
        Result cc=menuService.queryAll();
        return cc;
    }
}
