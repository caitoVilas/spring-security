package com.caito.infrastruture.services.contracts;

import com.caito.api.models.requests.ProductRequest;
import com.caito.api.models.responses.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAll();
    ProductResponse create(ProductRequest request);
}
