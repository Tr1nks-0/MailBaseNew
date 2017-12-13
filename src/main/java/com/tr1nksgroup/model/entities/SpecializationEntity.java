package com.tr1nksgroup.model.entities;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Специализация
 * 6.04.051.[010].17.01
 */
@Entity
@Table(name = "specialization")
public class SpecializationEntity extends AbstrEntity {
    /**
     * шифр специализации
     */
    @Basic
    @Column(name = "specialization_id", nullable = false, length = 3)
    private int specialization;
    /**
     * название специализации
     */
    @Basic
    @Column(name = "name", nullable = false, length = 30)
    private String name;

    //region get-set
    public int getSpecialization() {
        return specialization;
    }

    public void setSpecialization(int specialization) {
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion
}