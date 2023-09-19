package com.caito.domain.repositories;

import com.caito.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author claudio.vilas
 * date 09/2023
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


}
