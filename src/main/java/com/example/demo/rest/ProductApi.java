package com.example.demo.rest;


import com.example.demo.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Tag(name = "Product Api")
public interface ProductApi {

    ResponseEntity<Product> createProduct(Product product);

    @Operation(
            summary = "Get all products by type",
            description = "Get all products for the given type")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            content = {@Content(schema = @Schema(implementation = Product.class))})
            })
    ResponseEntity<List<Product>> getProductsByType(String type);

    ResponseEntity<Optional<Product>> getProductsByIdAndVersion(String id, Long version);

    ResponseEntity<List<Product>> getProductsById(String id);

    ResponseEntity<Optional<Product>> getProductByIdAndLatestVersion(String id);

}
