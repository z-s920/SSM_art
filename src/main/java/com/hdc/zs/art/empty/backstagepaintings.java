package com.hdc.zs.art.empty;

public class backstagepaintings {
    private Integer id;
    private String paintsName;
    private Integer sellingPrice;

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

    public Integer getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Integer sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public backstagepaintings(Integer id, String paintsName, Integer sellingPrice) {
        this.id = id;
        this.paintsName = paintsName;
        this.sellingPrice = sellingPrice;
    }

    @Override
    public String toString() {
        return "backstageCpaintings{" +
                "id=" + id +
                ", paintsName='" + paintsName + '\'' +
                ", sellingPrice=" + sellingPrice +
                '}';
    }
}
