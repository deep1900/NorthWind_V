package com.northwind.shipping.mapping;

import com.northwind.shipping.model.PackingSlipsDetails;

public class PackingSlipDetailsMapper
{
    public static PackingSlipDetailsModel toModel(PackingSlipsDetails packingSlipsDetails){
        PackingSlipDetailsModel model = new PackingSlipDetailsModel();
        model.setId(packingSlipsDetails.getId());
        model.setPackingSlipId(packingSlipsDetails.getPackingslips().getPackingSlipId());
        model.setProductName(packingSlipsDetails.getProductName());
        model.setQuantity(packingSlipsDetails.getQuantity());
        model.setVersion(packingSlipsDetails.getVersion());
        return model;
    }
}
