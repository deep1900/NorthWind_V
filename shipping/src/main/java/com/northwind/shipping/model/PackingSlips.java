package com.northwind.shipping.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "PackingSlips")
public class PackingSlips
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PackingSlipID")
    private long packingSlipId;
    @Column(name = "OrderID")
    private long orderId;
    @Column(name = "ShipName")
    private String shipName;
    @Column(name = "ShipAddress")
    private String shipAddress;
    @Column(name = "ShipCity")
    private String shipCity;
    @Column(name = "ShipRegion")
    private String shipRegion;
    @Column(name = "ShipPostalCode")
    private String shipPostalCode;
    @Column(name = "ShipCountry")
    private String shipCountry;
    @Column(name = "Version")
    private int version;
    @OneToMany(mappedBy = "packingslips", cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<PackingSlipsDetails> packingSlipsDetails = new ArrayList<>();

    public PackingSlips() {
    }

    public PackingSlips(long packingSlipId, long orderId, String shipName, String shipAddress, String shipCity, String shipRegion, String shipPostalCode, String shipCountry, int version, List<PackingSlipsDetails> packingSlipsDetails) {
        this.packingSlipId = packingSlipId;
        this.orderId = orderId;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipRegion = shipRegion;
        this.shipPostalCode = shipPostalCode;
        this.shipCountry = shipCountry;
        this.version = version;
        this.packingSlipsDetails = packingSlipsDetails;
    }

    public long getPackingSlipId() {
        return packingSlipId;
    }

    public void setPackingSlipId(long packingSlipId) {
        this.packingSlipId = packingSlipId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<PackingSlipsDetails> getPackingSlipsDetails() {
        return packingSlipsDetails;
    }

    public void setPackingSlipsDetails(List<PackingSlipsDetails> packingSlipsDetails) {
        this.packingSlipsDetails = packingSlipsDetails;
    }


    @Override
    public String toString() {
        return "PackingSlips{" +
                "packingSlipId=" + packingSlipId +
                ", orderId=" + orderId +
                ", shipName='" + shipName + '\'' +
                ", shipAddress='" + shipAddress + '\'' +
                ", shipCity='" + shipCity + '\'' +
                ", shipRegion='" + shipRegion + '\'' +
                ", shipPostalCode='" + shipPostalCode + '\'' +
                ", shipCountry='" + shipCountry + '\'' +
                ", version=" + version +
                ", packingSlipsDetails=" + packingSlipsDetails +
                '}';
    }

    public List<PackingSlipsDetails> getItems() {
        return Collections.unmodifiableList(packingSlipsDetails);
    }

    public void addItem(PackingSlipsDetails packingSlipDetails){
        this.packingSlipsDetails.add(packingSlipDetails);
        packingSlipDetails.setPackingslips(this);
    }
    public void removeItem(PackingSlipsDetails item) {
        packingSlipsDetails.remove(item);
    }
}
