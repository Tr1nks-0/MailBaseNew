package com.tr1nksgroup.model.services;

import com.tr1nksgroup.model.entities.FacultyEntity;
import com.tr1nksgroup.model.entities.GroupEntity;
import com.tr1nksgroup.model.entities.SpecializationEntity;
import com.tr1nksgroup.model.entities.StudyLevelEntity;

public interface GroupService {
    GroupEntity getByStudyLevelEntityAndFacultyEntityAndSpecializationEntityAndYearAndNum(StudyLevelEntity studyLevelEntity,
                                                                                          FacultyEntity facultyEntity,
                                                                                          SpecializationEntity specializationEntity,
                                                                                          Integer year,
                                                                                          Integer num);

    GroupEntity save(GroupEntity groupEntity);
}
