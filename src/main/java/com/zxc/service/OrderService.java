package com.zxc.service;

import java.math.BigDecimal; /**
 * Created with IntelliJ IDEA.
 * User: zxc
 * Date: 2021/01/24 19:43
 * Description:
 * Version: V1.0
 */
public interface OrderService {
    /**
     * 下单操作
     * @param pay_total_price
     * @param user_id
     * @param product_id
     * @param quantity
     * @param unit_price
     */
    void orderOperat(BigDecimal pay_total_price, Integer user_id, int product_id, int quantity, BigDecimal unit_price);
}
