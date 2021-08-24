package com.hhxf.hhip;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
class HhipApplicationTests {

    @Autowired
    StringEncryptor encryptor;

    @Test
    void contextLoads() {
        //设置数据库连接加密
//        String username=encryptor.encrypt("root");
//        System.out.println(username);
//        String password =encryptor.encrypt("");
//        System.out.println(password);
    }

}
