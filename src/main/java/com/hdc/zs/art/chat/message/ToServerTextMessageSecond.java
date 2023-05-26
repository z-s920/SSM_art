package com.hdc.zs.art.chat.message;
/**
 *
 * Created by DELL() on 2020/6/10 16:11
 */
public class ToServerTextMessageSecond {

	public ToServerMessageMine getMine() {
        return mine;
    }

    public void setMine(ToServerMessageMine mine) {
        this.mine = mine;
    }

    public ToServerMessageTo getTo() {
        return to;
    }

    public void setTo(ToServerMessageTo to) {
        this.to = to;
    }
    private ToServerMessageMine mine;
    private ToServerMessageTo to;

    @Override
    public String toString() {
        return "ToServerTextMessageSecond{" +
                "mine=" + mine +
                ", to=" + to +
                '}';
    }
}
