package com.caito.api.controller;

import com.caito.api.models.requests.ProductRequest;
import com.caito.api.models.responses.ProductResponse;
import com.caito.infrastruture.services.contracts.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author claudio.vilas
 * date 09/2023
 */

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll(){
        log.info("#### endpoint mostrar productos ####");
        List<ProductResponse> response = productService.getAll();
        if (response.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request){
        log.info("#### endpoint creacion de productos ####");
        ProductResponse response = productService.create(request);
        return ResponseEntity.ok(response);
    }
}
