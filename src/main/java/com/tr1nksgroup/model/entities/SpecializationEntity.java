package com.tr1nksgroup.model.entities;


import javax.persistence.*;

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
    private int specializationId;
    /**
     * название специализации
     */
    @Basic
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Basic
    @ManyToOne
    @JoinColumn(name = "speciality_id", referencedColumnName = "speciality_id", nullable = false)
    private SpecialityEntity specialityEntity;

    public SpecializationEntity(int specializationId, String name, SpecialityEntity specialityEntity) {
        this.specializationId = specializationId;
        this.name = name;
        this.specialityEntity = specialityEntity;
    }

    //    private
    //region get-set
    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpecialityEntity getSpecialityEntity() {
        return specialityEntity;
    }

    public void setSpecialityEntity(SpecialityEntity specialityEntity) {
        this.specialityEntity = specialityEntity;
    }
    //endregion
}
