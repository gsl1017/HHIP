package com.hhxf.hhip.Impl;

import com.hhxf.hhip.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userDao")
public interface UserDao extends JpaRepository<User,String> {
    List<User> getUserById(String id);
    List<User> getByAccountAndPwd(String account,String pwd);
}
