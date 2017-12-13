package com.tr1nksgroup.model.repositories;

import com.tr1nksgroup.model.entities.FacultyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<FacultyEntity, Long> {
    FacultyEntity getByFacultyId(Integer facultyId);
}
