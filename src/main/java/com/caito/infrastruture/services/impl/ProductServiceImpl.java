package com.caito.infrastruture.services.impl;

import com.caito.api.models.requests.ProductRequest;
import com.caito.api.models.responses.ProductResponse;
import com.caito.domain.entities.ProductEntity;
import com.caito.domain.repositories.ProductRepository;
import com.caito.infrastruture.services.contracts.ProductService;
import com.caito.utils.maps.MapProduct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author claudio.vilas
 * date 09/2023
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    @Override
    public List<ProductResponse> getAll() {
        log.info("---> inicio servicio buscar productos");
        log.info("---> buscando productos...");
        List<ProductEntity> products = productRepository.findAll();
        if (products.isEmpty())
            return null;
        log.info("---> finalizado servicio buscar productos");
        return products.stream().map(MapProduct::mapToDto).collect(Collectors.toList());
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        log.info("---> inicio servicio crear producto");
        log.info("---> validando entradas...");
        log.info("---> validacion OK");
        log.info("---> guardando producto...");
        ProductEntity product = productRepository.save(MapProduct.mapToEntity(request));
        log.info("---> finalizado servicio guardar producto");
        return MapProduct.mapToDto(product);
    }

    private void validateProduct(ProductRequest request){
        if (request.getName().isEmpty())
            throw  new RuntimeException();
        if (request.getPrice().floatValue() < 0.01)
            throw  new RuntimeException();
    }
}
