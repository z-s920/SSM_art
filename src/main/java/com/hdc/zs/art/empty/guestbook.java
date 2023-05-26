package com.hdc.zs.art.empty;

import java.text.SimpleDateFormat;
import java.util.Date;

public class guestbook {
    private String comment;
    private String stars;
    private String times;
    private String username;
    private Integer id;
    private String paintsName;
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaintsName() {
        return paintsName;
    }

    public void setPaintsName(String paintsName) {
        this.paintsName = paintsName;
    }
}
