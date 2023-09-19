package com.caito.utils.maps;

import com.caito.api.models.requests.ProductRequest;
import com.caito.api.models.responses.ProductResponse;
import com.caito.domain.entities.ProductEntity;

/**
 * @author claudio.vilas
 * date 09/2023
 */

public class MapProduct {
    public static ProductEntity mapToEntity(ProductRequest request){
        return ProductEntity.builder()
                .name(request.getName())
                .price(request.getPrice())
                .build();
    }

    public static ProductResponse mapToDto(ProductEntity entity){
        return ProductResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .build();
    }
}
