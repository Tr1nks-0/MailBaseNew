package com.tr1nksgroup.model.services;

import com.tr1nksgroup.model.entities.FacultyEntity;

import java.util.List;

public interface FacultyService {
    FacultyEntity getByFacultyId(Integer integer);

    List<FacultyEntity> saveAll(List<FacultyEntity> facultyEntityList);

    boolean containsByFacultyId(int facultyId);

    FacultyEntity save(FacultyEntity facultyEntity);
}
