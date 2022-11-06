package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.model.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, ProductId> {

    List<Product> findProductByType(String type);

    @Query("SELECT c FROM Product c WHERE c.productId.id = :id")
    List<Product> findProductByProductId(@Param("id") String id);

    @Query("SELECT p FROM Product p WHERE p.productId.id = :id AND p.productId.version = (SELECT MAX(pr.productId.version) FROM Product pr WHERE pr.productId.id = :id)")
    Optional<Product> findProductByIdAndLatestVersion(@Param("id") String id);


}
