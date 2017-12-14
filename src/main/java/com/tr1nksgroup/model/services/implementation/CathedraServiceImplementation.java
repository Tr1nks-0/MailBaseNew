package com.tr1nksgroup.model.services.implementation;

import com.tr1nksgroup.model.entities.CathedraEntity;
import com.tr1nksgroup.model.repositories.CathedraRepository;
import com.tr1nksgroup.model.services.CathedraService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CathedraServiceImplementation implements CathedraService {
    /**
     * {@inheritDoc}
     */
    @Resource
    private CathedraRepository cathedraRepository;

    @Override
    public boolean containsByAbbr(String abbr) {
        return null != cathedraRepository.getByAbbr(abbr);
    }

    @Override
    public CathedraEntity save(CathedraEntity cathedraEntity) {
        return cathedraRepository.saveAndFlush(cathedraEntity);
    }
}
