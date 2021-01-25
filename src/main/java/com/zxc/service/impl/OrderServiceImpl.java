package com.zxc.service.impl;

import com.zxc.mapper.OrderMapper;
import com.zxc.service.OrderService;
import com.zxc.utils.OrderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: zxc
 * Date: 2021/01/24 19:44
 * Description:订单操作
 * Version: V1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired(required = false)
    private OrderMapper orderMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void orderOperat(BigDecimal pay_total_price, Integer user_id, int product_id, int quantity, BigDecimal unit_price) {
        //订单号：
        String order_id =  OrderUtils.getOrderCode(user_id);
        //生成订单时间
        Timestamp create_time = new Timestamp(System.currentTimeMillis());
        //1、生成订单
        orderMapper.generateOrder(order_id,pay_total_price,create_time,user_id);
        //2、生成订单详情
        orderMapper.generateOrderDetail(order_id,product_id,quantity,unit_price);
    }
}
