package com.hdc.zs.art.empty;

import java.util.Date;

public class MyOrders {
    //pay_time,sn,total_amount,img
    private Date create_time;//支付时间
    private String sn;
    private Integer total_amount;
    private String img;
    private Integer count;
    private String title;

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Integer total_amount) {
        this.total_amount = total_amount;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MyOrders{" +
                "create_time=" + create_time +
                ", sn='" + sn + '\'' +
                ", total_amount=" + total_amount +
                ", img='" + img + '\'' +
                ", count=" + count +
                ", title='" + title + '\'' +
                '}';
    }
}
