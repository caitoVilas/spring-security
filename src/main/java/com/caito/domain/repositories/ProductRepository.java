package com.caito.domain.repositories;

import com.caito.domain.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author claudio.vilas
 * date 09/2023
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
