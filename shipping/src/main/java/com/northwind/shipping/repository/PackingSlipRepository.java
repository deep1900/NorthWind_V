package com.northwind.shipping.repository;

import com.northwind.shipping.model.PackingSlips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackingSlipRepository extends JpaRepository<PackingSlips,Long >
{
}
