package com.tr1nksgroup.model.repositories;

import com.tr1nksgroup.model.entities.SpecializationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository extends JpaRepository<SpecializationEntity, Long> {
    SpecializationEntity getBySpecializationId(Integer SpecializationId);
}
