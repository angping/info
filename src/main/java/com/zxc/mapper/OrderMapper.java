package com.zxc.mapper;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.sql.Timestamp; /**
 * Created with IntelliJ IDEA.
 * User: zxc
 * Date: 2021/01/24 19:46
 * Description:
 * Version: V1.0
 */
public interface OrderMapper {
    /**
     * 生成订单
     * @param order_id
     * @param pay_total_price
     * @param create_time
     * @param user_id
     */
    void generateOrder(@Param("order_id") String order_id, @Param("pay_total_price") BigDecimal pay_total_price, @Param("create_time") Timestamp create_time, @Param("user_id") Integer user_id);

    /**
     * 生成订单详情表
     * @param order_id
     * @param product_id
     * @param quantity
     * @param unit_price
     */
    void generateOrderDetail(@Param("order_id") String order_id, @Param("product_id") int product_id, @Param("quantity") int quantity, @Param("unit_price") BigDecimal unit_price);
}
