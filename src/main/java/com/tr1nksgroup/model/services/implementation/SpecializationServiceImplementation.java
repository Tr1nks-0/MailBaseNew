package com.tr1nksgroup.model.services.implementation;

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
    public SpecializationEntity getBySpecializationId(Integer integer) {
        return specializationRepository.getBySpecializationId(integer);
    }
}
