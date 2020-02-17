package com.northwind.shipping.model;


import javax.persistence.*;


@Entity
@Table(name="PackingSlipDetails")
public class PackingSlipsDetails
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PackingSlipDetailsID")
    private long id;

//    @Column(name = "PackingSlipID")
//    private long packingSlipId;
    @Column(name = "ProductName")
    private String productName;
    @Column(name = "Quantity")
    private int quantity;
    @Column(name = "Version")
    private int version;
//     @MapsId("PackingSlipID")
    @ManyToOne(optional = false)
    @JoinColumn(name = "PackingSlipID", nullable = false)
    private PackingSlips packingslips;

    public PackingSlipsDetails() {
    }

    public PackingSlipsDetails(long id, String productName, int quantity, int version, PackingSlips packingslips) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.version = version;
        this.packingslips = packingslips;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public PackingSlips getPackingslips() {
        return packingslips;
    }

    public void setPackingslips(PackingSlips packingslips) {
        this.packingslips = packingslips;
    }

    @Override
    public String toString() {
        return "PackingSlipsDetails{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", version=" + version +
                ", packingslips=" + packingslips +
                '}';
    }
}
