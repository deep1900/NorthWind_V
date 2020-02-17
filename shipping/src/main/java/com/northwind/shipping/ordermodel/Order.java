package com.northwind.shipping.ordermodel;


import java.math.BigDecimal;

import java.util.Date;
import java.util.List;


public class Order
{

    private String id;

    private String customerId;

    private String customerNo;

    private String companyName;

    private java.util.Date orderDate;

    private BigDecimal total;

    private Date shippedDate;

    private String shipName;

    private String shipAddress;

    private String shipCity;

    private String shipRegion;

    private String shipPostalCode;
    private String shipCountry;
    private String status;
    private long version;
    private List<OrderItem> items;


    public Order() {
    }

    public Order(String orderNo, String customerId, String customerNo, String companyName, Date orderDate, BigDecimal total, Date shippedDate, String shipName, String shipAddress, String shipCity, String shipRegion, String shipPostalCode, String shipCountry, String status, long version, List<OrderItem> items) {
        this.id = orderNo;
        this.customerId = customerId;
        this.customerNo = customerNo;
        this.companyName = companyName;
        this.orderDate = orderDate;
        this.total = total;
        this.shippedDate = shippedDate;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipRegion = shipRegion;
        this.shipPostalCode = shipPostalCode;
        this.shipCountry = shipCountry;
        this.status = status;
        this.version = version;
        this.items = items;
    }

    public String getOrderNo() {
        return id;
    }

    public void setOrderNo(String orderNo) {
        this.id = orderNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerNo='" + customerNo + '\'' +
                ", companyName='" + companyName + '\'' +
                ", orderDate=" + orderDate +
                ", total=" + total +
                ", shippedDate=" + shippedDate +
                ", shipName='" + shipName + '\'' +
                ", shipAddress='" + shipAddress + '\'' +
                ", shipCity='" + shipCity + '\'' +
                ", shipRegion='" + shipRegion + '\'' +
                ", shipPostalCode='" + shipPostalCode + '\'' +
                ", shipCountry='" + shipCountry + '\'' +
                ", status='" + status + '\'' +
                ", version=" + version +
                ", items=" + items +
                '}';
    }
}
