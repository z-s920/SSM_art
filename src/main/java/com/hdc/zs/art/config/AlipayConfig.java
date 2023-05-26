package com.hdc.zs.art.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。*/

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016103000778757";

	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCDG+SuYqjTqy5Qy+WdVcayAXWELFObBddLEOj1E3gNNrthljXA+rPe8cRydSzZEhaAHlQ7ao5tGWDFR5wBIHbEgwm8Db+GCcxA9uYLusbHI2Q2N2zy3Ll7qISXM4+06pd9kaS5j2N3pajV1zIN6/aFYuygn1MriODMkhSXnASdfxPGWmBhfJc2YJC68aMXHEJDxVAR6pRQKyXcPOQkKUL8GB3sVAVw6uy/+8nYLyZwcQRIqbTQuCgiNlL8KAKwIV4o1iR3TtXDby5gXdWt5HIL2tvktCiv6VzW/hhDfAeSrgHq+Pi+OR0HwJOYmQ+NlroMraeVfKYvDYs+5bPRIJD3AgMBAAECggEAFuwPhTWWkrtA87tSP7m5bXG33A3r6BSTWXpxYDexK45AIIWkjELIo9fdIq29043IBUpIK8Mrd4OSWat1aPUGDsFiOFCnBYY9Abao7bAQBMz5PklecO+KNkZ2OAE5xMWnCrsl85NQLqD17b0b8Tcp+JQdDtAMOHZL5zg7BW6vl+FYFMo135HZTH4I7ut4XGp78ywN3weBM/9IAVfVrYo4roDDdLxHD5Lk9Jy1Me6W752DGdIpRuOIQ6yPjpN6KTgsIjpezJq5wai2LUlO67wMIVhS1YMd0ouunlZxuOOtEWnXtF7S/DertLjPRbaZNP5BqFyMlB6ZT6tVsVBIikEWoQKBgQDmMRIIE7P5V0AJQf+EA48h/VPrwqkY5xfVSb43n5RHumjQk7cj96r7EXznU+BahsJpd9h21c9grRQ7fSBqWLOedRGdwSWdaG+CkneDbLiZvKm7ySZbJmt+2FcMuKYlR6gIEhAsw6vWy0kaPxSK9iMC/N7T4EepdcO7LN2UihtfjwKBgQCRzvbelkTSR4alqHtGiSSk/0J+eIOQ3s82/553fah1iwZwTQudVRnFdF45dZx794Y8/gKjnWkLN7e20ToSlX0XGNVwWOoHDzPd5WpcVH+K+SnLB/unP+gaGHToQZDNT71WhOPOdTKFXgN42LGhEKZIrRgiSzAhF2FgQRXjbqoEGQKBgQCkYix/Shq/F9iqA9CFpMkFO9Q/S57YIsd5UBUfwbzxUCRjtukVLVuTudRZmiNgYlXZXXVev6c9YbxOEzgf2cJDiVSQNIs5Eoh3VUM1vmFBoGIRsT7L3u7rAXGAqygy/S34vXWBkiZX2IoWzS9NYSJ1ksFJyyNB19B0DUEbP1j27wKBgE0Psl/v0Y3Fab9x7T1ZTDm8Axuue/J8H840iT8j9X2yLYP65FGR4Z3/I7GAnGTUbGkd4q0wi4z3NKx1phieU096u4u2InH6sfHrxyvnKMV9bH42yOUbHIN2O4to46vvIeVxNKkwPbRI/NLIzBCRKSEuApxVWqmSns9tdrEOEuM5AoGAPsgi0oVeGeI2LDjM0ap6hsgBk50QFyuFfyPoLR2iMcPuTmj33fmJHhdnXgoYL4iKBcN9KGoEvX3BAkJwVFfKWrXsWenKZ9IZr5St37WwLFfpeHCIj1XlMtI4BCtxPkUukA2dOl66OvL9eY0ih27LDNhg0HI3329bCvFZpqzh1qg=";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvXfJQs9HWOQUmxR1GscCsFHPCyQG9zddAJORmqDNDEQYo1NILuTwooz4BdujK99wv/tTv4nPdkkASp2zUETaPBec3pL0FjE/l4SoLlIe4rQbj6jFMFWKHnccwGdU5iOa+4FDYevmMPpf/rJZac5hko8164QcZ7ss9rhJvAGsd28nQUnlVxxnsGKbyuo35rmjbxgBLj9Onprf1lcGKllw2WOciBL7LsF/65P6eE/Fv92J0/4kXuz5xh1KACtfAn2Jq8YM//k5D/OhCT7PiLOae32WyOHB3BjwR6VSAvDssZYqcp3uhXNiafn6eJ1FH/LcCwrSRCr9ReKTuqEz2sLsCQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://zsart.free.idcfengye.com/pay/alipay_notify ";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://zsart.free.idcfengye.com/pay_log/list";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关
	/*public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";*/
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";



//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑


}


