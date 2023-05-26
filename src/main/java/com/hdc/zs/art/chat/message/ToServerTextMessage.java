package com.hdc.zs.art.chat.message;

/**
 *
 * Created by DELL(mxd) on 2020/6/10 16:11
 */
public class ToServerTextMessage {
	
	private String type;
	private ToServerTextMessageSecond data;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ToServerTextMessageSecond getData() {
		return data;
	}

	public void setData(ToServerTextMessageSecond data) {
		this.data = data;
	}
	
	/*private String type;
	private String tarUser;
	private String srcUser;
	private String message;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTarUser() {
		return tarUser;
	}
	public void setTarUser(String tarUser) {
		this.tarUser = tarUser;
	}
	public String getSrcUser() {
		return srcUser;
	}
	public void setSrcUser(String srcUser) {
		this.srcUser = srcUser;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ToServerTextMessage [type=" + type + ", tarUser=" + tarUser + ", srcUser=" + srcUser + ", message="
				+ message + "]";
	}
	public ToServerTextMessage(String type, String tarUser, String srcUser, String message) {
		super();
		this.type = type;
		this.tarUser = tarUser;
		this.srcUser = srcUser;
		this.message = message;
	}*/
	
}
