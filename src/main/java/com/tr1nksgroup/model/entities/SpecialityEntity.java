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
    @Column(name = "speciality_id", nullable = false, unique = true, length = 3)
    private int specialityId;
    /**
     * название специальности
     */
    @Basic
    @Column(name = "name", nullable = false, length = 70)
    private String name;

    public SpecialityEntity(int specialityId, String name) {
        this.specialityId = specialityId;
        this.name = name;
    }

    private SpecialityEntity() {
    }

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
