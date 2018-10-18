package com.kdx.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092200569360";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCMCSuIp//cM2M00KII51eh86ngM0PQTMSUqjxWSB0U6ec1pLNYzDgc3R9atW57XsIXElKhxw++gd9nKjowX86wsv/Y7g8LalheV0jrdIsiu6X4u+jYn4scJii9S8/8rdbmdaz8V7DPeNmiEVqA+YQWECeq3ajQbrWnvuH+ZHERAmjLmkwnSzd4JYBokPBvFXi30oGLxWFAkVOtPyPfJ/vPG8Y34Sx7QUXQLBRD9nLJnvkXb028xLeagekUctmWd3AJapnFl6ZhZ73wzvH2NrH1H/yXmbKirHsK3+D1AvMCA97L68R/+MwuKxyVieCK6GbKMQAwNc7otu77RvWHYqAjAgMBAAECggEAEAV0j5v47+6JKR+9ihs9sW+5PcdfuNMvonqfkJeLjDr+kuqXAk/LE7JQxgX/7+l1d0JHZe7qZDdjod/47FPpx9mS3/TMj9fI6HJAC4A38u9ZG84T48TNG5laC95Cm3wgHBnWgsBdoD8JVzt5CUyCyitq/meByub/rYNvQ7WmIfXjQ1Js2vgUkuzJ79uKBiFtqwRdwpongnJaMCm9oOH1U6gh3ZJFUtNuGprddRxfnBfc6q0nEP9fg7L0kiKr+7xt0Jn+ftQ0exzAh3tqFjb01vUq1IniiR0+ovEBw2VM49UiKWY+Mv6koGyzQoz1hWvvL3NWSEZXsLZb52Ny2I1vMQKBgQDDIbF2PpHRxYLbmjBxmIn/zgORh93kRAB45OvxgciHS8epfmtjSWZnMyM2GrPBMvhpl5XGYeU3qQtBIElejI38cr90skK7oLriQECumRSKYSM/97mnEeN3SSIFVb3e7G0Lp5pXJTIrqYRxjnBZ/skXdG3jJKx5sHh+GJAEwIynlQKBgQC3t8gwebq11HVF77fEf/pxLpHuwMh7qyzLrIkUo7hsVPtKNlk2WEYLiy3gR2FCvwZl5UAZ9R0TQ++C1nvlex06DrhJToLCfOUAJVMkpfUv6WlRJ3brByFiQbg8BtJZoMDAe14S1bpqvdQWmhwMttGmNuEq/QnqHO2jj8VFuRna1wKBgHcOLaqJjorAyZCXSQtmGHy9A6xdi2Lkoq0gb1zQ5Lq338BoY7kWZaZ9qvQt4pL0OGCknjuGK0aEm1tHCbzoYREwKeRXhyPXc27r6QseV0v+7HTw/pMS9Qgo1NsQb2J+OiIsRpz5Et1U9nwafi5KqALphMpb6+frZfj5n5VmrerpAoGAfCBAsnfcbXPBVGI1YB8zn3regFhiXCP4HRhSec5wEUmNisOTnQMhODVt5oVzsjwMX5X3rFIOtfCFh3nQtehrg8lkO6s+75agxmtxdGZodVmXnYwzbXIg3RkYF/5n6sSQ1rvDgKhEzk+5VxgCcZinp0yW74uNQk8PRB4kJAp+7HsCgYAKqFIrQX8awGeFAS7OfBwfiLfuaI+i0oQU8qrk969OGHRCcNQHSHyQZFTERLxv0e3rMfmnWSBiZWRN64buhQ4EN8yiWX00En9YKWfB9P11T6oRFPXWknhGAASBgpS6QhjFSqpuIGJO7ppcYCZp0syRwqmr3YIzG1i++vTi6UxJxA==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1vsN+RI2BvRIf1kKXSJFpc0bJvHuCZSgI3cXnOdegJLDqfs6Ovh2Vl8MgQllxishzb66B8QiYn8PPA5orIskFZrc7IMZ/mcRrys49yEmVG5dX1zx0lHKjpgfSccJpCMxvYNuzAdvBGN7qXRuq82NccpH+0djKFDB1WFzxKyrw+K8SvlwFQmrfURNXpDWZObNFP9syn8/kST/DWfBvgvc1XI/0wVp+phroaGyPO36PCyc0uM1ziaHclXP+C0Q0dgE5w7+YD+3jpy22W6iHcr4JIoMhhQbASZY9xL2P5NMjeYfsQ0v8PgueVHswYPtAj8AIXdsT/BWtj+ycWejBZ4KnQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://loaclhost:8080/RunAleg/alipay/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://loaclhost:8080/RunAleg/alipay/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "D:\\";


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

