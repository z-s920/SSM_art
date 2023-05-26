package com.hdc.zs.art.empty;

public class updateWestern {

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

    public updateWestern(Integer id, String paintsName) {
        this.id = id;
        this.paintsName = paintsName;
    }

    @Override
    public String toString() {
        return "updateWestern{" +
                "id=" + id +
                ", paintsName='" + paintsName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
