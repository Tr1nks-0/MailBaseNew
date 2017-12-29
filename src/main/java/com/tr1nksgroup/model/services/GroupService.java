package com.tr1nksgroup.model.services;

import com.tr1nksgroup.model.entities.FacultyEntity;
import com.tr1nksgroup.model.entities.GroupEntity;
import com.tr1nksgroup.model.entities.SpecializationEntity;
import com.tr1nksgroup.model.entities.StudyLevelEntity;

import java.util.List;

public interface GroupService {
    GroupEntity getByStudyLevelEntityAndFacultyEntityAndSpecializationEntityAndYearAndNum(StudyLevelEntity studyLevelEntity,
                                                                                          FacultyEntity facultyEntity,
                                                                                          SpecializationEntity specializationEntity,
                                                                                          Integer year,
                                                                                          Integer num);

    GroupEntity getByStudyLevelEntityLevelIdAndFacultyEntityFacultyIdAndSpecializationEntitySpecializationIdAndYearAndNum(int studyLevelEntityLevelId,
                                                                                                                          int facultyEntityFacultyId,
                                                                                                                          int specializationEntitySpecialityEntitySpecialityId,
                                                                                                                          int specializationEntitySpecializationId,
                                                                                                                          int year,
                                                                                                                          int num);


    GroupEntity save(GroupEntity groupEntity);

    List<GroupEntity> getAll();
}
