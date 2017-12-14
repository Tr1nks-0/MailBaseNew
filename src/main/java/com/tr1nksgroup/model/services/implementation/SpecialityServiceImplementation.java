package com.tr1nksgroup.model.services.implementation;

import com.tr1nksgroup.model.entities.SpecialityEntity;
import com.tr1nksgroup.model.repositories.SpecialityRepository;
import com.tr1nksgroup.model.services.SpecialityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SpecialityServiceImplementation implements SpecialityService {
    /**
     * {@inheritDoc}
     */
    @Resource
    private SpecialityRepository specialityRepository;

    @Override
    public SpecialityEntity getBySpecialityId(Integer integer) {
        return specialityRepository.getBySpecialityId(integer);
    }
}
