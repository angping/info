package com.zxc.service.impl;

import com.zxc.mapper.ProductsMapper;
import com.zxc.pojo.Product_Info;
import com.zxc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zxc
 * Date: 2021/01/22 16:56
 * Description:
 * Version: V1.0
 */

@Service
public class ProductsServictImpl implements ProductService {

    @Autowired(required = false)
    private ProductsMapper productsMapper;
    @Override
    public List<Product_Info> queryPhoneList() {
        return productsMapper.queryPhoneList();
    }

    @Override
    public Product_Info PhoneDetails(String productId) {
        return productsMapper.PhoneDetails(productId);
    }
}
