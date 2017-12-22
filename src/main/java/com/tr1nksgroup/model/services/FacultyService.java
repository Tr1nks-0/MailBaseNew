package com.tr1nksgroup.model.services;

import com.tr1nksgroup.model.entities.FacultyEntity;

import java.util.List;

public interface FacultyService {
    FacultyEntity getByFacultyId(Integer integer);

    boolean containsByFacultyId(int facultyId);

    FacultyEntity save(FacultyEntity facultyEntity);

    List<FacultyEntity> getAll();

    List<FacultyEntity> getAllByIds(List<Long> facultyIds);
}
