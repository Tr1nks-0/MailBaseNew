package com.tr1nksgroup.model.repositories;

import com.tr1nksgroup.model.entities.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
    TeacherEntity getFirstByLogin(String login);
}
