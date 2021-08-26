package com.hhxf.hhip.Service;

import com.hhxf.hhip.Impl.MenuDao;
import com.hhxf.hhip.Impl.UserDao;
import com.hhxf.hhip.Model.Menu;
import com.hhxf.hhip.Model.User;
import com.hhxf.hhip.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    UserDao userDao;
    @Resource
    MenuDao menuDao;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Result getListByuserid(String userid){
        List<Menu> menuls=new ArrayList<>();
        User user=userDao.getById(userid);
        String sql="select * from menu where state=1 and pid is null and id in ("+user.getMenus()+")";
        List<Map<String,Object>> maps= jdbcTemplate.queryForList(sql);
        for(int i=0;i<maps.size();i++){
            Menu menu=JSON.parseObject(JSON.toJSONString(maps.get(i)), Menu.class);
            List<Menu> aa=menuDao.getMenusByPid(menu.getId());
            aa=aa.stream().filter(menu1 -> menu1.getState().equals(1)).collect(Collectors.toList());
            menu.setChildren(aa);
            menuls.add(menu);
        }
        return new Result(menuls);
    }
    @Override
    public Result queryAll(){
        List<Menu> list=menuDao.findAll();
        return new Result(list);
    }
}
