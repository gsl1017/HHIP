package com.hhxf.hhip.Service;

import com.hhxf.hhip.Impl.UserDao;
import com.hhxf.hhip.Model.User;
import com.hhxf.hhip.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;
    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    JdbcTemplate secondaryJdbcTemplate;
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    JdbcTemplate primaryJdbcTemplate;

    @Override
    public Result save(User user){
        User save=userDao.save(user);
        return new Result(save);
    }
    @Override
    public Result queryAll(){
        String sql="select * from user";
        List<Map<String,Object>> maps= primaryJdbcTemplate.queryForList(sql);
        return new Result(maps);
    }

    @Override
    public Result queryOracleUser(){
        String sql="select * from t_bd_person where fnumber='305132'";
        List<Map<String,Object>> maps= secondaryJdbcTemplate.queryForList(sql);
        return new Result(maps);
    }

    @Override
    public Result getById(String id)
    {
        List<User> list=userDao.getUserById(id);
        return new Result(list);
    }

    @Override
    public User getByAccount(String account){
        User list=userDao.getByAccount(account);
        return list;
    }

//    @Override
//    public Result Login(String account,String pwd){
//        String sql="select * from user where account='"+account+"' and pwd=password('"+pwd+"') and state=1";
////                "select * from user where account='\" +account + \"' and pwd=password('\" + pwd + \"') and state=1";
//        List<Map<String,Object>> maps= jdbcTemplate.queryForList(sql);
//        System.out.println(sql);
//        System.out.println(maps);
//        return new Result(maps);
//    }
}
