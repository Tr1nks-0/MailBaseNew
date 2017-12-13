package com.tr1nksgroup.model.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Специальность
 * 6.04.[051].010.17.01
 */
@Entity
@Table(name = "speciality")
public class SpecialityEntity extends AbstrEntity {
    /**
     * шифр специальности
     */
    @Basic
    @Column(name = "speciality_id", nullable = false, length = 3)
    private int speciality;
    /**
     * название специальности
     */
    @Basic
    @Column(name = "name", nullable = false, length = 30)
    private String name;

    //region get-set
    public int getSpeciality() {
        return speciality;
    }

    public void setSpeciality(int speciality) {
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion
}
