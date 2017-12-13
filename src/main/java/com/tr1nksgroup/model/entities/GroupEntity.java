package com.tr1nksgroup.model.entities;

import javax.persistence.*;

/**
 * академ группа
 */
@Entity
@Table(name = "academ_group")
public class GroupEntity extends AbstrEntity {
    /**
     * уровень обучения
     * [6].04.051.010.17.01
     */
    @Basic
    @ManyToOne
    @JoinColumn(name = "level_id", referencedColumnName = "level_id", nullable = false)
    private StudyLevelEntity studyLevelEntity;
    /**
     * факультет к которому предлежит группа
     * 6.[04].051.010.17.01
     */
    @Basic
    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id", nullable = false)
    private FacultyEntity facultyEntity;
    /**
     * специальность группы
     * 6.04.[051].010.17.01
     */
    @Basic
    @ManyToOne
    @JoinColumn(name = "speciality_id", referencedColumnName = "speciality_id", nullable = false)
    private SpecialityEntity specialityEntity;
    /**
     * специализация группы
     * 6.04.051.[010].17.01
     */
    @Basic
    @ManyToOne
    @JoinColumn(name = "specialization_id", referencedColumnName = "specialization_id", nullable = false)
    private SpecializationEntity specializationEntity;
    /**
     * год поступления
     * 6.04.051.010.[17].01
     */
    @Basic
    @Column(name = "year", nullable = false, length = 3)
    private int year;
    /**
     * номер группы
     * 6.04.051.010.17.[01]
     */
    @Basic
    @Column(name = "num", nullable = false, length = 3)
    private int num;
//    /**
//     * студенты группы
//     */
//    @OneToMany(mappedBy = "group")
//    private List<StudentEntity> students;


    //region get-set

    public StudyLevelEntity getStudyLevelEntity() {
        return studyLevelEntity;
    }

    public void setStudyLevelEntity(StudyLevelEntity studyLevelEntity) {
        this.studyLevelEntity = studyLevelEntity;
    }

    public FacultyEntity getFacultyEntity() {
        return facultyEntity;
    }

    public void setFacultyEntity(FacultyEntity facultyEntity) {
        this.facultyEntity = facultyEntity;
    }

    public SpecialityEntity getSpecialityEntity() {
        return specialityEntity;
    }

    public void setSpecialityEntity(SpecialityEntity specialityEntity) {
        this.specialityEntity = specialityEntity;
    }

    public SpecializationEntity getSpecializationEntity() {
        return specializationEntity;
    }

    public void setSpecializationEntity(SpecializationEntity specializationEntity) {
        this.specializationEntity = specializationEntity;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    //endregion
}
