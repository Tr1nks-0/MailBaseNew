package com.tr1nksgroup.model.services;

import com.tr1nksgroup.model.entities.SpecialityEntity;
import com.tr1nksgroup.model.entities.SpecializationEntity;

public interface SpecializationService {

    SpecializationEntity getBySpecializationIdAndSpecialityEntity(Integer integer, SpecialityEntity specialityEntity);

    SpecializationEntity save(SpecializationEntity specializationEntity);

    boolean containsByspecializationIdAndSpecialityEntity(int specializationId, SpecialityEntity specialityEntity);
}
