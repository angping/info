package com.zxc.controller;

import com.zxc.common.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: zxc
 * Date: 2021/01/24 14:52
 * Description:支付成功后的控制类
 * Version: V1.0
 */
@Controller
public class PaySuccessController {

    @RequestMapping(value = "/return_url",method = RequestMethod.GET)
    @ResponseBody
    public R paySuccess(HttpServletRequest request){
        //取返回参数 函数里一一对应
        //2、HttpServletRequest   request.getParameterMap();

        R r=new R();

        r.setCode(200);
        r.setMsg("支付成功");
        r.setData(request.getParameterMap());
        return r;
    }
}
