package com.tr1nksgroup.model.services.implementation;

import com.tr1nksgroup.model.entities.StudyLevelEntity;
import com.tr1nksgroup.model.repositories.StudyLevelRepository;
import com.tr1nksgroup.model.services.StudyLevelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudyLevelServiceImplementation implements StudyLevelService {
    /**
     * {@inheritDoc}
     */
    @Resource
    private StudyLevelRepository studyLevelRepository;

    @Override
    public StudyLevelEntity getByLevelId(Integer integer) {
        return studyLevelRepository.getByLevelId(integer);
    }

    @Override
    public boolean containsByLevelId(Integer integer) {
        return null != getByLevelId(integer);
    }

    @Override
    public StudyLevelEntity save(StudyLevelEntity studyLevelEntity) {
        return studyLevelRepository.saveAndFlush(studyLevelEntity);
    }
}
