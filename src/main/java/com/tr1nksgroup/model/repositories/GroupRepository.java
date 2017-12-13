package com.tr1nksgroup.model.repositories;

import com.tr1nksgroup.model.entities.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
}
