package com.hdc.zs.art.chat.message;

/**
 *
 * Created by DELL(mxd) on 2020/6/10 16:11
 */
public class ToServerMessageMine {
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String avatar;

    private String id;

    private String content;

    private String username;

    private boolean mine;

	public boolean isMine() {
		return mine;
	}

	public void setMine(boolean mine) {
		this.mine = mine;
	}

    @Override
    public String toString() {
        return "ToServerMessageMine{" +
                "avatar='" + avatar + '\'' +
                ", id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                ", mine=" + mine +
                '}';
    }
}
