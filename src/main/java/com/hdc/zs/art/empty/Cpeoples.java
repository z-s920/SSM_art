package com.hdc.zs.art.empty;

public class Cpeoples {
    private Integer id;
    private String paintsName;
    private String paintsCoverImg;
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

    public String getPaintsCoverImg() {
        return paintsCoverImg;
    }

    public void setPaintsCoverImg(String paintsCoverImg) {
        this.paintsCoverImg = paintsCoverImg;
    }

    public Cpeoples(Integer id, String paintsName, String paintsCoverImg) {
        this.id = id;
        this.paintsName = paintsName;
        this.paintsCoverImg = paintsCoverImg;

    }

    @Override
    public String toString() {
        return "Cpeoples{" +
                "id=" + id +
                ", paintsName='" + paintsName + '\'' +
                ", paintsCoverImg='" + paintsCoverImg + '\'' +
                '}';
    }
}
