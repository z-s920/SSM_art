package com.hdc.zs.art.bean;
//支付方式枚举类
public enum Payment {

	WxPay(false,"微信支付"),
	Alipay(true,"支付宝支付");
	
	private boolean enable;
	private String  name;

	private Payment(boolean enable,String name)
	{
		this.enable=enable;
		this.name=name;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
