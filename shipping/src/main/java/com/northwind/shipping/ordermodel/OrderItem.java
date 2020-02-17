package com.northwind.shipping.ordermodel;



public class OrderItem {
   
    private OrderItemKey id;
   
    private String productName;
   
    private String quantityPerUnit;
   
    private String unitPrice;
   
    private String quantity;
   
    private String discount;
   
    private String version;

    public OrderItem() {
    }

    public OrderItem(OrderItemKey id, String productName, String quantityPerUnit, String unitPrice, String quantity, String discount, String version) {
        this.id = id;
        this.productName = productName;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.discount = discount;
        this.version = version;
    }

    public OrderItemKey getId() {
        return id;
    }

    public void setId(OrderItemKey id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", quantityPerUnit='" + quantityPerUnit + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", quantity='" + quantity + '\'' +
                ", discount='" + discount + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
