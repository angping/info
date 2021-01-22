package com.zxc.controller;

import com.zxc.common.R;
import com.zxc.pojo.Product_Info;
import com.zxc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zxc
 * Date: 2021/01/22 16:35
 * Description:
 * Version: V1.0
 */

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/queryPhoneList", method = RequestMethod.GET)
    @ResponseBody

    public R queryPhoneList(){
        R r=new R();
        List<Product_Info> product_info=productService.queryPhoneList();

        r.setCode(200);
        r.setMsg("查询成功");
        r.setData(product_info);

        return r;
    }
}
