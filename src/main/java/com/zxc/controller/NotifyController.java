package com.zxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotifyController {

    @RequestMapping(value = "notify_url")
    public String paySuccess(){
        return "支付成功";
    }
}
