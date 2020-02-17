package com.northwind.catalog.repository;

import com.northwind.catalog.model.Catagories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatagoryRepository extends JpaRepository<Catagories, Long> {
}
