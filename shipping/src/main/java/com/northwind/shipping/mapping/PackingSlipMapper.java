package com.northwind.shipping.mapping;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.northwind.shipping.model.PackingSlips;

@JsonSerialize
public class PackingSlipMapper
{
    public static PackingSlipsModel toModel(PackingSlips packingSlips)
    {
        PackingSlipsModel model = new PackingSlipsModel();
        model.setOrderId(packingSlips.getOrderId());
        model.setPackingSlipId(packingSlips.getPackingSlipId());
        model.setShipAddress(packingSlips.getShipAddress());
        model.setShipCity(packingSlips.getShipCity());
        model.setShipCountry(packingSlips.getShipCountry());
        model.setShipName(packingSlips.getShipName());
        model.setShipPostalCode(packingSlips.getShipPostalCode());
        model.setShipRegion(packingSlips.getShipRegion());
        model.setVersion(packingSlips.getVersion());
        return model;

    }


}
