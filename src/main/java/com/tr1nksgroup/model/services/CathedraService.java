package com.tr1nksgroup.model.services;

import com.tr1nksgroup.model.entities.CathedraEntity;

public interface CathedraService {
    boolean containsByAbbr(String abbr);

    CathedraEntity save(CathedraEntity cathedraEntity);
}
