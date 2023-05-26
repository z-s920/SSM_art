package com.hdc.zs.art.chat.message;

/**
 *
 *
 */
public class ToServerMessageTo {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	private String id;
    private String avatar;
    private String sign;  // 签名
    private String type;
    private String name;
    private String username;
    private String status;

    @Override
    public String toString() {
        return "ToServerMessageTo{" +
                "id='" + id + '\'' +
                ", avatar='" + avatar + '\'' +
                ", sign='" + sign + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
