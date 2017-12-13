package com.tr1nksgroup.model.services.implementation;

import com.tr1nksgroup.model.entities.FacultyEntity;
import com.tr1nksgroup.model.repositories.FacultyRepository;
import com.tr1nksgroup.model.services.FacultyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class FacultyServiceImplementation implements FacultyService {
    /**
     * {@inheritDoc}
     */
    @Resource
    private FacultyRepository facultyRepository;

    @Override
    public FacultyEntity getByFacultyId(Integer integer) {
        return facultyRepository.getByFacultyId(integer);
    }
}
