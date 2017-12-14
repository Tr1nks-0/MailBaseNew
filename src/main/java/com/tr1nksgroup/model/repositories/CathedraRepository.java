package com.tr1nksgroup.model.repositories;

import com.tr1nksgroup.model.entities.CathedraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CathedraRepository extends JpaRepository<CathedraEntity, Long> {
    CathedraEntity getByAbbr(String abbr);
}
