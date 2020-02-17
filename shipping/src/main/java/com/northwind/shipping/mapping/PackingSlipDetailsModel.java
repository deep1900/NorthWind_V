package com.northwind.shipping.mapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;



@JsonSerialize
public class PackingSlipDetailsModel {
    @JsonProperty
    private long id;
    @JsonProperty
    private long packingSlipId;
    @JsonProperty
    private String productName;
    @JsonProperty
    private int quantity;
    @JsonProperty
    private int version;

    public PackingSlipDetailsModel() {
    }

    public PackingSlipDetailsModel(long id, long packingSlipId, String productName, int quantity, int version) {
        this.id = id;
        this.packingSlipId = packingSlipId;
        this.productName = productName;
        this.quantity = quantity;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPackingSlipId() {
        return packingSlipId;
    }

    public void setPackingSlipId(long packingSlipId) {
        this.packingSlipId = packingSlipId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "PackingSlipDetailsModel{" +
                "id=" + id +
                ", packingSlipId=" + packingSlipId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", version=" + version +
                '}';
    }
}
