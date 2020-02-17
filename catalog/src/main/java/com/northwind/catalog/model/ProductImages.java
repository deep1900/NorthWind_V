package com.northwind.catalog.model;

import javax.persistence.*;

@Entity
@Table(name="ProductImages")
public class ProductImages
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ProductImageID")
    private long productImageId;
    @Column(name="ProductID")
    private int productId;
    @Column(name="ImageUri")
    private String imageUri;
    @Column(name="Version")
    private int version;

    public ProductImages() {
    }

    public ProductImages(Long productImageId, int productId, String imageUri, int version) {
        this.productImageId = productImageId;
        this.productId = productId;
        this.imageUri = imageUri;
        this.version = version;
    }

    public Long getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(long productImageId) {
        this.productImageId = productImageId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "ProductImages{" +
                "productImageId=" + productImageId +
                ", productId=" + productId +
                ", imageUri='" + imageUri + '\'' +
                ", version=" + version +
                '}';
    }
}
