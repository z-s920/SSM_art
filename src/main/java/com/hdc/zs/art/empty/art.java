package com.hdc.zs.art.empty;

public class art {
    private Integer id;
    private String name;
    private String img;
    private String des;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }


    @Override
    public String toString() {
        return "art{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", des='" + des + '\'' +
                '}';
    }

    public art(Integer id, String name,  String des) {
        this.id = id;
        this.name = name;
        this.des = des;
    }
}
