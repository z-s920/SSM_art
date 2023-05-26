package com.hdc.zs.art.empty;

public class Wpeoples {
    private Integer id;
    private String paintsName;
    private String paintsCoverImg;
    private String description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Wpeoples(Integer id, String paintsName, String paintsCoverImg, String description) {
        this.id = id;
        this.paintsName = paintsName;
        this.paintsCoverImg = paintsCoverImg;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Wpeoples{" +
                "id=" + id +
                ", paintsName='" + paintsName + '\'' +
                ", paintsCoverImg='" + paintsCoverImg + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
