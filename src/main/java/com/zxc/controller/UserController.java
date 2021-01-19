package com.zxc.controller;

import com.sun.deploy.net.HttpResponse;
import com.zxc.common.R;
import com.zxc.pojo.Users;
import com.zxc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: zxc
 * Date: 2021/01/18 16:35
 * Description: controller主要用于接受页面的请求，并且做出相应的响应
 * Version: V1.0
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    //注解   依赖注入
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody //返回json数据
    //public void register(Users users,HttpServletResponse response){//注册   Servlet中如何跳转页面
   // public ModelAndView register(Users users){//注册
    public R register(Users users){//注册

        //继续将参数传递给业务逻辑层,后续进行注册功能，如果注册成功跳转到登录页面，否则返回注册页面

            R r=new R();

        try {
            int result=userService.addUser(users);   //传递参数
            if(result>0){//注册成功
                //跳转登录页面 Servlet中如何跳转页面 1、重定向 2、转发
             //  response.sendRedirect("login.html");

                //ModelAndView modelAndView=new ModelAndView("/login.html");
               // return modelAndView;

                //return "响应页面地址";
                //return "redirect:/login.html";  //重定向到登录页面，不走视图解析器（不走前缀和后缀）

                r.setCode(200);
                r.setMsg("注册成功");
                System.out.println("=====注册成功====");


            }
        }catch (Exception e){
            //e.printStackTrace();
            System.out.println("===系统开小差了，请联系管理员===");
            r.setCode(500);
            r.setMsg("注册失败");
        }

       return r;
    }
}
