package com.tr1nksgroup.model.repositories;

import com.tr1nksgroup.model.entities.FacultyEntity;
import com.tr1nksgroup.model.entities.GroupEntity;
import com.tr1nksgroup.model.entities.SpecializationEntity;
import com.tr1nksgroup.model.entities.StudyLevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
//    @Query("select g from GroupEntity g where concat(g.studyLevelEntity,'.',g.facultyEntity,'.',g.specialityEntity,'.',g.specializationEntity,'.',g.year,'.',g.num) like :cipher")

    /*SELECT *
FROM academ_group ag
WHERE ag.level_id = (SELECT id FROM studylevel sl WHERE sl.level_id = ?) AND
      ag.faculty_id = (SELECT id FROM faculty fc WHERE fc.faculty_id = ?) AND
      ag.specialization_id = (SELECT id FROM specialization sz WHERE sz.specialization_id = ? AND
                                                                     sz.speciality_id = (SELECT id FROM speciality sp WHERE sp.speciality_id = ?)) AND
      ag.year = ? AND
      ag.num = ?*/

    //    @Query("select ag from GroupEntity ag where ag.studyLevelEntity=(select sl from StudyLevelEntity where )")
//    GroupEntity getByStudyLevelEntityAndFacultyEntityAndSpecializationEntityAndYearAndNum(@Param("cipher") String cipher);
    GroupEntity getByStudyLevelEntityAndFacultyEntityAndSpecializationEntityAndYearAndNum(
            StudyLevelEntity studyLevelEntity,
            FacultyEntity facultyEntity,
            SpecializationEntity specializationEntity,
            Integer year,
            Integer num);
}
