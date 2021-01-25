package com.zxc.controller;

import com.zxc.common.R;
import com.zxc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: zxc
 * Date: 2021/01/24 19:26
 * Description:
 * Version: V1.0
 */
@Controller
public class OrderController {

    @Autowired(required = false)
    private OrderService orderService;

    @RequestMapping(value = "/order",method = RequestMethod.POST)
    @ResponseBody
    public R orderOperat(BigDecimal pay_total_price,Integer user_id,int product_id,int quantity,BigDecimal unit_price){
        R r = new R();
        try{
            orderService.orderOperat(pay_total_price,user_id,product_id,quantity,unit_price);
            r.setCode(200);
            r.setMsg("操作成功");
        }catch (Exception e){
            r.setCode(500);
            r.setMsg("系统错误，请联系管理员");
            e.printStackTrace();
        }
        return r;
    }
}
