package com.tr1nksgroup.model.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * факультет
 * 6.[04].051.010.17.01
 */
@Entity
@Table(name = "faculty")
public class FacultyEntity extends AbstrEntity{
    /**
     * шифр факультета
     */
    @Basic
    @Column(name = "faculty_id", nullable = false, length = 3)
    private int faculty;
    /**
     * название факультета
     */
    @Basic
    @Column(name = "name", nullable = false, length = 30)
    private String name;
}
