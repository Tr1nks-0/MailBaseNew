package com.tr1nksgroup.model.entities;

import javax.persistence.*;
import java.util.List;

/**
 * кафедра
 */
@Entity
@Table(name = "cathedra")
public class CathedraEntity extends AbstrEntity {
//    /**
//     * шифр кафедры
//     */
//    @Basic
//    @Column(name = "cathedra_id", nullable = false, length = 3)
//    private int cathedraId;
    /**
     * факультет к которому предлежит кафедра
     */
    @Basic
    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id", nullable = false)
    private FacultyEntity faculty;
    /**
     * название кафедры
     */
    @Basic
    @Column(name = "name", nullable = false, length = 70)
    private String name;
    /**
     * аббревиатура названия кафедры
     */
    @Basic
    @Column(name = "abbr", nullable = false, length = 7)
    private String abbr;
    /**
     * преподаватели кафедры
     */
    @OneToMany(mappedBy = "cathedra")
    private List<TeacherEntity> teacherEntities;


    //region get-set
//    public int getCathedraId() {
//        return cathedraId;
//    }
//
//    public void setCathedraId(int cathedraId) {
//        this.cathedraId = cathedraId;
//    }

    public FacultyEntity getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyEntity faculty) {
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getAbbr() {
        return abbr;
    }

    public List<TeacherEntity> getTeacherEntities() {
        return teacherEntities;
    }

    public void setTeacherEntities(List<TeacherEntity> teacherEntities) {
        this.teacherEntities = teacherEntities;
    }

    //endregion
}
