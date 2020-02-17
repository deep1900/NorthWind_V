package com.northwind.catalog.model;

import javax.persistence.*;
import java.util.Arrays;


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
