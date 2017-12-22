package com.tr1nksgroup.model.services.implementation;

import com.tr1nksgroup.model.entities.FacultyEntity;
import com.tr1nksgroup.model.entities.GroupEntity;
import com.tr1nksgroup.model.entities.SpecializationEntity;
import com.tr1nksgroup.model.entities.StudyLevelEntity;
import com.tr1nksgroup.model.repositories.GroupRepository;
import com.tr1nksgroup.model.services.GroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GroupServiceImplementation implements GroupService {
    @Resource
    private GroupRepository groupRepository;

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public GroupEntity getByStudyLevelEntityAndFacultyEntityAndSpecializationEntityAndYearAndNum(
            StudyLevelEntity studyLevelEntity,
            FacultyEntity facultyEntity,
            SpecializationEntity specializationEntity,
            Integer year,
            Integer num) {
        return groupRepository.getByStudyLevelEntityAndFacultyEntityAndSpecializationEntityAndYearAndNum(
                studyLevelEntity,
                facultyEntity,
                specializationEntity,
                year,
                num);
    }

    @Override
    public GroupEntity save(GroupEntity groupEntity) {
        return groupRepository.saveAndFlush(groupEntity);
    }

    @Override
    public List<GroupEntity> getAll() {
        return groupRepository.findAll();
    }

}
