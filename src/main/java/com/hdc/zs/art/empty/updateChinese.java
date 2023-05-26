package com.hdc.zs.art.empty;

public class updateChinese {
    private Integer id;
    private String paintsName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public updateChinese(Integer id, String paintsName, String description) {
        this.id = id;
        this.paintsName = paintsName;
        this.description = description;
    }

    @Override
    public String toString() {
        return "updateChinese{" +
                "id=" + id +
                ", paintsName='" + paintsName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
