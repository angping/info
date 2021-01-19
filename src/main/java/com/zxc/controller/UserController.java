package com.zxc.controller;

import com.zxc.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: zxc
 * Date: 2021/01/18 16:35
 * Description:
 * Version: V1.0
 */

@Controller
public class UserController {

    //注解
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public void register(Users users){//注册

        System.out.println(users.getUser_email());
        System.out.println(users.getUser_tel());
        System.out.println(users.getUser_pwd());
    }
}
