package com.hdc.zs.art.empty;

public class gallery {
    private Integer id;
    private String name;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public gallery(Integer id, String name, String des) {
        this.id = id;
        this.name = name;
        this.des = des;
    }

    @Override
    public String toString() {
        return "gallery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
