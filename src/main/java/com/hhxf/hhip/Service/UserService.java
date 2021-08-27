package com.hhxf.hhip.Service;

import com.hhxf.hhip.Model.User;
import com.hhxf.hhip.util.Result;

public interface UserService {

    Result save(User o);

    Result queryAll();

    Result queryOracleUser();

    Result getById(String id);

    User getByAccount(String account);

//    Result getByAccountAndPwd(String account,String pwd);

//    Result Login(String account,String pwd);

}
