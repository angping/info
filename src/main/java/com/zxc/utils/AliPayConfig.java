package com.zxc.utils;
import java.io.FileWriter;
import java.io.IOException;
/* *
 *类名：AliPayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
public class AliPayConfig {

   //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    // 支付宝网关
    public static final String GATEWAY_URL = "https://openapi.alipaydev.com/gateway.do";

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static final String APP_ID = "2021000116692084";

    // 商户私钥，您的PKCS8格式RSA2私钥  -- 自己的私钥
    public static final String MERCHANT_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCt+i+VQWR4BOJngFbbQjBc+SImCOlNI3tIAw50QInk8n8vU5+7ilcgd7Uk8HCrif8FrhsL0vChpPSSHnJ2kIzbt97iaIAf1zz7VlkI5hYbreik5t8VOGRqMq4ydKpBV9BqulMltJg8N28NyUgH1AO/jM852+JHmgfJY8AOPOLCvhnMtSdVUTPnseKv3UgEbfmrs1i2TPOxrvGb9+1Vax87mh6Pqmn9tDECNJCtVU4fxJkcle0DA1F1svCcsFXpMRDQrrK6aTC4u0ywuoB/Et4BzV6+H+ndN/Xx7JMze0Ise2b1us8PPFHmvV5DVEowDgpZdAaCaNVfizsiPDuXXSOZAgMBAAECggEBAKVBvOkd0H1gxl5iPh7PZHkr/Q/77wBi77ubi6NJmrJq1fzyhgvygIhKrTqFWcDXt/KBSxeUKxagReB2I2wUKnia05Bkiy+zmC11++TECcQJEa9xzf2uL1PhCC7NOtwOud5nVou+W8z3KvoBc/ZboaPV8RGYl/xDh5n4snnTw+IOdo35/irVBmECodZmJrgQ/l+VS50JtC4Q7NjEnijX4jjF0TddJetNpn5fOxoNNlqyYIRPiZBGo5iU4dNBZzE4Trc7bvl+TKymI0bBNYMN+FdyAab1S+hVr92pIFBxzqg59CLItBMlwiUIbV24yvQNDF3gdN7oSczcOviEyBGz0vECgYEA5uP3EjE7n4KhOdbYuOd3I3hOAZF1V0ltqTsrcQepbXsGI6GM0LA9rLeqI3BBSXCJsShq2Dpt1BHoiQMJl0kcC2ivhgfKIqIEvzCswLuIeWId+0hf0FzrXypO0/PzjUgdcHwCAZgfFsEweV5XaU7OUG0q5u1jz4P9vwjGj/sybm8CgYEAwOW/GhKFEV4zmkDDbojSwOFQu5cLSiECOH9jbbDWr/1PAA61VoyyGuaOEogzYqjYQ1W6i0S1lTYojOgVqx9FGkQL2RDam+LBNlC+XSIG/69q2zkfaU5rHjWTU5kBYrQA8NBbU3plgPqTBROtrCPaHg3a71KThR70FF4Fbz9YEncCgYBHGjC943du+bVYsHbxCibAP44WIYs3JB+nG9eW6TsdweL0Gg3ZPkzf4Xd9jlYsnYFpkv7EM8oaoqEvgEX11sfSI5zZ85Al9irsDbtFZvryFmsRNQp8igDZv5ei4d9AxNJ8D1Q21XfNdBTPa2QTw/b5AYVStAwmnYkIyVUMhdjT9QKBgDvckGuU57q2EymBg6SfzVeSFK3Cd/xvNfM2hTKbOGSxJX0NE3VigDsc5WYW4mtxnnt29UcW8Yr2narssxzBvX4jM9IPCuhpfDBQ6mKYlrduRqj1lyvk7BUZ5ziAOQ/acJhK8Kx9RVa7bDidHL5Y+e1tu02dwK4FJxXS/7jAXaKNAoGAKvhtJtQxS7SPYLigfxLWeZhje6rfK+xyuCjnjSaRbVadc7BA6F1mr26aIHlySRQ9kGqY6a+i3mgo0cpoUd8kNi0Mv5Okq8kPLAP33UaTr0xg3eaiDR9VXG8HS+/41TnMcEo1rC9fHDg2VQhQ7vLJqE2lPf52wuMfHuDB9NV7fXQ=";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkwfFkhj5U8X66uEkZgpteFMuGoctRJL0DMrzPvGJzrKtqBGFJorrfo/qGx444kBqg8BRqhkaZXZDufmcyE40gaB4mf2fkshyoCUEsda2LQKG3nFwlmjTl9AlXzhIcpFobDpOg+2O0j3u8lXC1ATAkOM8Lvbk47stSZpm3VBD20owKLdWUpZSgCY+rru0raQx8ChFWZPwYiN2B71NAlkgNnImROHY99MxkEDASYfkgbLqpmp+ePwDgyA9Py3UFkfh/teFHxIuXFTHT8ODBqQg5BrqTyumBzaYbYj8ZL3Xbb85TZ/k8Vbv4e6QmsqOox6KyCU3WeZGJLoRbcWfeiRwQwIDAQAB";

    // 签名方式
    public static final String SIGN_TYPE = "RSA2";

    // 字符编码格式
    public static final String CHARSET = "utf-8";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/notify_url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/return_url";

    // 支付宝网关
    public static String log_path = "C:\\";

   //↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


