package com.zxc.controller;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.zxc.utils.AliPayUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AliPayController {

    @RequestMapping(value = "/alipay",method = RequestMethod.GET,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String aliPay(String out_trade_no,String subject,String total_amount,String body){
        AlipayTradePagePayResponse alipayTradePagePayResponse = AliPayUtil.simpleParamPagePay(out_trade_no,subject,total_amount,body,"5m","");
        String form = alipayTradePagePayResponse.getBody();
        // 返回一个表单给用户端, 接下来由用户和支付宝服务器进行通信
        return form;
    }
}
