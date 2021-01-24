package com.zxc.utils;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeCloseModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.internal.util.StringUtils;
import com.alipay.api.request.*;
import com.alipay.api.response.*;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;

public class AliPayUtil {

    public static AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.GATEWAY_URL, AliPayConfig.APP_ID, AliPayConfig.MERCHANT_PRIVATE_KEY, "json", AliPayConfig.CHARSET, AliPayConfig.ALIPAY_PUBLIC_KEY, AliPayConfig.SIGN_TYPE);
    /**
     * 电脑网站支付接口 - 简单参数(PC场景下单并支付，可传递的其它非必要参数可查阅官方文档)
     *
     * @api alipay.trade.page.pay
     *
     * @param out_trade_no
     *            商户订单号，商户网站订单系统中唯一订单号，必填
     * @param subject
     *            订单名称，必填
     * @param total_amount
     *            付款金额，必填
     * @param body
     *            商品描述，可空
     * @param timeout_express
     *            该笔订单允许的最晚付款时间，逾期将关闭交易，该参数在请求到支付宝时开始计时。
     *            取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
     *            该参数数值不接受小数点， 如 1.5h，可转换为 90m。
     * @param passback_params
     *            公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数。支付宝只会在异步通知时将该参数原样返回。本参数必须进行UrlEncode之后才可以发送给支付宝，
     *            如：merchantBizType%3d3C%26merchantBizNo%3d2016010101111
     */
    public static AlipayTradePagePayResponse simpleParamPagePay(String out_trade_no, String subject,
                                                                String total_amount, String body, String timeout_express, String passback_params) {

        // 设置请求参数，请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        // 设置请求参数，请求参数可查阅【wap支付的API文档-alipay.trade.wap.pay-请求参数】章节
//         AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();
        // 页面跳转同步通知页面路径
        alipayRequest.setReturnUrl(AliPayConfig.return_url);
        // 服务器异步通知页面路径，在公共参数中设置回跳和通知地址
        alipayRequest.setNotifyUrl(AliPayConfig.notify_url);

        // 填充业务参数
        alipayRequest.setBizContent("{" + "\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\""
                + total_amount + "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
                + "\"timeout_express\":\"" + timeout_express + "\"," + "\"passback_params\":\"" + passback_params
                + "\"," + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
          //扫描支付：product_code=FAST_INSTANT_TRADE_PAY 支付方式：product_code=QUICK_WAP_PAY 登录账号支付

        AlipayTradePagePayResponse response = null;
//        AlipayTradeWapPayResponse response = null;
        try {
            // 调用SDK生成表单
            response = alipayClient.pageExecute(alipayRequest);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if (response == null) {
            response = new AlipayTradePagePayResponse();
        }
        return response;
    }




    /**
     * 统一收单线下交易查询
     *
     * @api alipay.trade.query
     * @param out_trade_no
     *            商户订单号，商户网站订单系统中唯一订单号(与支付宝交易号二选一设置)
     * @param trade_no
     *            支付宝交易号(与商户订单号二选一设置) out_trade_no、trade_no如果同时存在优先取trade_no
     */
    public static AlipayTradeQueryResponse tradeQuery(String out_trade_no, String trade_no) {

        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();

        if (!StringUtils.isEmpty(trade_no)) {
            request.setBizContent(
                    "{" + "\"out_trade_no\":\"" + out_trade_no + "\"," + "\"trade_no\":\"" + trade_no + "\"" + "  }");
        } else if (!StringUtils.isEmpty(out_trade_no)) {
            request.setBizContent("{" + "\"out_trade_no\":\"" + out_trade_no + "\"," + "\"trade_no\":\"\"" + "  }");
        }

        AlipayTradeQueryResponse response = null;

        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if (response == null) {
            response = new AlipayTradeQueryResponse();
        }
        return response;
    }

    /**
     * 统一收单交易退款接口
     *
     * @api alipay.trade.refund
     *
     * @param out_trade_no
     *            商户订单号，商户网站订单系统中唯一订单号（请二选一设置：out_trade_no/trade_no）
     * @param trade_no
     *            支付宝交易号（请二选一设置：out_trade_no/trade_no）
     *            out_trade_no、trade_no如果同时存在优先取trade_no
     * @param refund_amount
     *            需要退款的金额，该金额不能大于订单金额，必填
     * @param refund_reason
     *            退款的原因说明
     * @param out_request_no
     *            标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
     */
    public static AlipayTradeRefundResponse refund(String out_trade_no, String trade_no, String refund_amount,
                                                   String refund_reason, String out_request_no) {
        // 设置请求参数
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"trade_no\":\"" + trade_no + "\","
                + "\"refund_amount\":\"" + refund_amount + "\"," + "\"refund_reason\":\"" + refund_reason + "\","
                + "\"out_request_no\":\"" + out_request_no + "\"}");

        AlipayTradeRefundResponse response = null;
        try {
            response = alipayClient.execute(alipayRequest);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if (response == null) {
            response = new AlipayTradeRefundResponse();
        }
        return response;
    }

    /**
     * 统一收单交易退款查询接口
     *
     * @api alipay.trade.fastpay.refund.query
     *
     * @param out_trade_no
     *            商户订单号，商户网站订单系统中唯一订单号（请二选一设置：out_trade_no/trade_no）
     * @param trade_no
     *            支付宝交易号（请二选一设置：out_trade_no/trade_no）
     *            out_trade_no、trade_no如果同时存在优先取trade_no
     * @param out_request_no
     *            请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号，必填
     */
    public static AlipayTradeFastpayRefundQueryResponse refundQuery(String out_trade_no, String trade_no,
                                                                    String out_request_no) {

        AlipayTradeFastpayRefundQueryRequest alipayRequest = new AlipayTradeFastpayRefundQueryRequest();
        if (!StringUtils.isEmpty(trade_no)) {
            alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"trade_no\":\"" + trade_no
                    + "\"," + "\"out_request_no\":\"" + out_request_no + "\"}");
        } else if (!StringUtils.isEmpty(out_trade_no)) {
            alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"trade_no\":\"\","
                    + "\"out_request_no\":\"" + out_request_no + "\"}");
        }

        AlipayTradeFastpayRefundQueryResponse response = null;
        try {
            response = alipayClient.execute(alipayRequest);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if (response == null) {
            response = new AlipayTradeFastpayRefundQueryResponse();
        }
        return response;
    }

    /**
     * 统一收单交易关闭接口
     *
     * @api alipay.trade.close
     * @param out_trade_no
     *            商户订单号，商户网站订单系统中唯一订单号（请二选一设置：out_trade_no/trade_no）
     * @param trade_no
     *            支付宝交易号（请二选一设置：out_trade_no/trade_no）
     *            out_trade_no、trade_no如果同时存在优先取trade_no
     */
    public static AlipayTradeCloseResponse close(String out_trade_no, String trade_no) {
        AlipayTradeCloseRequest alipay_request = new AlipayTradeCloseRequest();
        AlipayTradeCloseModel model = new AlipayTradeCloseModel();
        model.setOutTradeNo(out_trade_no);
        model.setTradeNo(trade_no);
        alipay_request.setBizModel(model);

        AlipayTradeCloseResponse response = null;
        try {
            response = alipayClient.execute(alipay_request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if (response == null) {
            response = new AlipayTradeCloseResponse();
        }
        return response;
    }

    /**
     * 验签签名
     *
     * @param params
     *            参数集
     * @param requestParams
     *            支付宝GET过来的反馈信息
     * @return
     */
    public static boolean verifySign(Map<String, String> params, Map<String, String[]> requestParams) {

        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            try {
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            params.put(name, valueStr);
        }

        boolean signVerified = false;
        try {
            // 调用SDK验证签名
            signVerified = AlipaySignature.rsaCheckV1(params, AliPayConfig.ALIPAY_PUBLIC_KEY, AliPayConfig.CHARSET,
                    AliPayConfig.SIGN_TYPE);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return signVerified;
    }


//    public static boolean verifyOrderInfo(Map<String,String> params, Order order) {
//        String outTradeNo = params.get("out_trade_no");
//        String totalAmoumt = params.get("total_amount");
//        String sellerId = params.get("seller_id");
//        String appId = params.get("app_id");
//        if(!outTradeNo.equals(order.getOutTradeNo()))
//            return false;
//        if(!totalAmoumt.equals(order.getTotalAmount()))
//            return false;
//        if(!sellerId.equals(AliPayConfig.MERCHANT_PRIVATE_KEY))
//            return false;
//        if(!appId.equals(AliPayConfig.APP_ID))
//            return false;
//        return true;
//    }
}
