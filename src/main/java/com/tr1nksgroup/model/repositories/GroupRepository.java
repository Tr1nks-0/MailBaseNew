package com.tr1nksgroup.model.repositories;

import com.tr1nksgroup.model.entities.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
    @Query("select g from GroupEntity g where concat(g.studyLevelEntity,'.',g.facultyEntity,'.',g.specialityEntity,'.',g.specializationEntity,'.',g.year,'.',g.num) like :cipher")
    GroupEntity getByCipher(@Param("cipher") String cipher);
}
