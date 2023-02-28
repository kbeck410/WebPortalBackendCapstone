package net.adminPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.adminPortal.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
