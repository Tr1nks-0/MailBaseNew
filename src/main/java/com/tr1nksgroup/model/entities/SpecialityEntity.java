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
    private int specialityId;
    /**
     * название специальности
     */
    @Basic
    @Column(name = "name", nullable = false, length = 30)
    private String name;

    //region get-set
    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion
}
