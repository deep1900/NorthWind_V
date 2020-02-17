package com.northwind.catalog.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Entity
@Table(name="Categories")
public class Catagories
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CategoryID")
    private long catagoryId;
    @Column(name="CategoryName")
    private String catagoryName;
    @Column(name="Description")
    private String meduimText;
    @Column(name="Picture")
    private byte[] picture;
    @Column(name="Version")
    private int version;
    @OneToMany(mappedBy = "catagories", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Products> productsList;

    public Catagories() {
    }

    public Catagories(long catagoryId, String catagoryName, String meduimText, byte[] picture, int version) {
        this.catagoryId = catagoryId;
        this.catagoryName = catagoryName;
        this.meduimText = meduimText;
        this.picture = picture;
        this.version = version;
    }

    public long getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(long catagoryId) {
        this.catagoryId = catagoryId;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    public String getMeduimText() {
        return meduimText;
    }

    public void setMeduimText(String meduimText) {
        this.meduimText = meduimText;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<Products> getItems() {
        return Collections.unmodifiableList(productsList);
    }

    public void addItem(Products products){
        this.productsList.add(products);
       // packingSlipDetails.setPackingslips(this);
        products.setCatagories(this);
    }
    public void removeItem(Products item) {
        productsList.remove(item);
    }

    @Override
    public String toString() {
        return "Catagories{" +
                "catagoryId=" + catagoryId +
                ", catagoryName='" + catagoryName + '\'' +
                ", meduimText='" + meduimText + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", version=" + version +
                '}';
    }
}
