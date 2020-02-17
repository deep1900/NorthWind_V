package com.northwind.inventory.model;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "Products")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private long productId;
    @Column(name = "ProductName")
    private String productName;
    @Column(name = "SupplierID")
    private long supplierId;
    @Column(name = "QuantityPerUnit")
    private String quantityPerUnit;
    @Column(name = "UnitPrice")
    private BigDecimal unitPrice;
    @Column(name = "UnitsInStock")
    private int unitsInStock;
    @Column(name = "UnitsOnOrder")
    private int unitsOnOrder;
    @Column(name = "ReorderLevel")
    private int reOrderLevel;
    @Column(name = "Discontinued")
    private boolean discontinued;
    @Column(name = "Location")
    private String location;
    @Column(name = "Version")
    private int version;
    @ManyToOne
    @JoinColumn(name = "SupplierID", nullable = false)
    @MapsId("SupplierID")
    private Supplier supplier;
    public Product() {
    }

    public Product(long productId, String productName, long supplierId, String quantityPerUnit, BigDecimal unitPrice, int unitsInStock, int unitsOnOrder, int reOrderLevel, boolean discontinued, String location, int version) {
        this.productId = productId;
        this.productName = productName;
        this.supplierId = supplierId;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.unitsOnOrder = unitsOnOrder;
        this.reOrderLevel = reOrderLevel;
        this.discontinued = discontinued;
        this.location = location;
        this.version = version;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
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

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public int getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(int unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    public int getReOrderLevel() {
        return reOrderLevel;
    }

    public void setReOrderLevel(int reOrderLevel) {
        this.reOrderLevel = reOrderLevel;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", supplierId=" + supplierId +
                ", quantityPerUnit='" + quantityPerUnit + '\'' +
                ", unitPrice=" + unitPrice +
                ", unitsInStock=" + unitsInStock +
                ", unitsOnOrder=" + unitsOnOrder +
                ", reOrderLevel=" + reOrderLevel +
                ", discontinued=" + discontinued +
                ", location='" + location + '\'' +
                ", version=" + version +
                '}';
    }
}
