package com.northwind.catalog.repository;

import com.northwind.catalog.model.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImages, Long> {
}
