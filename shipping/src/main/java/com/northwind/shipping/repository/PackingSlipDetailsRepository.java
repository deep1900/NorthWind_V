package com.northwind.shipping.repository;

import com.northwind.shipping.model.PackingSlipsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackingSlipDetailsRepository extends JpaRepository<PackingSlipsDetails, Long>
{
}
