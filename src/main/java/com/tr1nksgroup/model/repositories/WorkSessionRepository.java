package com.tr1nksgroup.model.repositories;

import com.tr1nksgroup.model.entities.WorkSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkSessionRepository extends JpaRepository<WorkSessionEntity, Long> {
}
