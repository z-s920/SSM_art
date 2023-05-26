package com.hdc.zs.art.chat.resulet;

/**
 *
 * Created by DELL(mxd) on 2020/6/10 16:11
 */
public class ToClientMessageResult {

    public ToClientMessageType getType() {
        return type;
    }

    public void setType(ToClientMessageType type) {
        this.type = type;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    private ToClientMessageType type;

    private Object msg;
}
