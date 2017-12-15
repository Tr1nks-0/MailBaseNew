package com.tr1nksgroup.model.services.implementation;

import com.tr1nksgroup.model.entities.SpecialityEntity;
import com.tr1nksgroup.model.entities.SpecializationEntity;
import com.tr1nksgroup.model.repositories.SpecializationRepository;
import com.tr1nksgroup.model.services.SpecializationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SpecializationServiceImplementation implements SpecializationService {
    /**
     * {@inheritDoc}
     */
    @Resource
    private SpecializationRepository specializationRepository;

    @Override
    public SpecializationEntity getBySpecializationIdAndSpecialityEntity(Integer integer, SpecialityEntity specialityEntity) {
        return specializationRepository.getBySpecializationIdAndSpecialityEntity(integer, specialityEntity);
    }

    @Override
    public SpecializationEntity save(SpecializationEntity specializationEntity) {
        return specializationRepository.save(specializationEntity);
    }

    @Override
    public boolean containsByspecializationIdAndSpecialityEntity(int specializationId, SpecialityEntity specialityEntity) {
        return null != this.getBySpecializationIdAndSpecialityEntity(specializationId, specialityEntity);
    }
}
