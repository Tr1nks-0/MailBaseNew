package com.tr1nksgroup.model.repositories;

import com.tr1nksgroup.model.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    @Query("SELECT s.id FROM StudentEntity s WHERE s.login = :login")
    Integer testEmail(@Param("login") String login);

    StudentEntity getFirstByLogin(String login);
}
