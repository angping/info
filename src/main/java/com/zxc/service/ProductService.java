package com.zxc.service;

import com.zxc.pojo.Product_Info;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zxc
 * Date: 2021/01/22 16:49
 * Description:
 * Version: V1.0
 */
public interface ProductService {
    /**
     * 查询所有商品信息
     * @return
     */
    List<Product_Info> queryPhoneList();
}
