package com.tr1nksgroup.model.services;

import com.tr1nksgroup.model.entities.FacultyEntity;

public interface FacultyService {
    FacultyEntity getByFacultyId(Integer integer);

    boolean containsByFacultyId(int facultyId);

    FacultyEntity save(FacultyEntity facultyEntity);
}
