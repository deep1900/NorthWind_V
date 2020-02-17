package com.northwind.catalog.model;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "Products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ProductID")
    private long productId;
    @Column(name="ProductName")
    private String productName;
    @Column(name="CategoryID")
    private int catagoryId;
    @Column(name="QuantityPerUnit")
    private String quantityPerUnit;
    @Column(name="ListPrice")
    private BigDecimal listPrice;
    @Column(name="Published")
    private boolean published;
    @Column(name="Version")
    private int version;
    @ManyToOne
    @MapsId("CategoryID")
    @JoinColumn(name = "CategoryID", nullable = false)
    private Catagories catagories;

    public Products() {
    }

    public Products(long productId, String productName, int catagoryId, String quantityPerUnit, BigDecimal listPrice, boolean published, int version, Catagories catagories) {
        this.productId = productId;
        this.productName = productName;
        this.catagoryId = catagoryId;
        this.quantityPerUnit = quantityPerUnit;
        this.listPrice = listPrice;
        this.published = published;
        this.version = version;
        this.catagories = catagories;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(int catagoryId) {
        this.catagoryId = catagoryId;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Catagories getCatagories() {
        return catagories;
    }

    public void setCatagories(Catagories catagories) {
        this.catagories = catagories;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", catagoryId=" + catagoryId +
                ", quantityPerUnit='" + quantityPerUnit + '\'' +
                ", listPrice=" + listPrice +
                ", published=" + published +
                ", version=" + version +
                '}';
    }
}
