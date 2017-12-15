package com.tr1nksgroup.model.repositories;

import com.tr1nksgroup.model.entities.SpecialityEntity;
import com.tr1nksgroup.model.entities.SpecializationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository extends JpaRepository<SpecializationEntity, Long> {
    SpecializationEntity getBySpecializationIdAndSpecialityEntity(Integer SpecializationId, SpecialityEntity specialityEntity);
}
