package com.northwind.shipping.service;

import com.northwind.shipping.mapping.PackingSlipDetailsMapper;
import com.northwind.shipping.mapping.PackingSlipDetailsModel;
import com.northwind.shipping.model.PackingSlipsDetails;
import com.northwind.shipping.repository.PackingSlipDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PackingSlipDetailService
{
    @Autowired
    PackingSlipDetailsRepository repository;
    public List<PackingSlipDetailsModel> findAllSlipDetails()
    {
        List<PackingSlipsDetails> packingSlips = repository.findAll();
        List<PackingSlipDetailsModel> packingSlipsDetailsModels = packingSlips.stream()
                .map(p-> PackingSlipDetailsMapper.toModel(p))
                .collect(Collectors.toList());
        return packingSlipsDetailsModels;
    }
}
