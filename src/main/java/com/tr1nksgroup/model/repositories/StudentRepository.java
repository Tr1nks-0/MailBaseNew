package com.tr1nksgroup.model.repositories;

import com.tr1nksgroup.model.entities.GroupEntity;
import com.tr1nksgroup.model.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    StudentEntity getFirstByLogin(String login);

    StudentEntity getFirstByCode(String code);

    StudentEntity getById(Long id);

    List<StudentEntity> getAllByGroupEntity_FacultyEntityIdIn(List<Long> ids);

    List<StudentEntity> getAllByGroupEntity_IdIn(List<Long> ids);

    List<StudentEntity> getAllByGroupEntity_YearIn(List<Integer> years);

    StudentEntity getBySurnameAndNameAndGroupEntity(String surname, String name, GroupEntity groupEntity);
}
