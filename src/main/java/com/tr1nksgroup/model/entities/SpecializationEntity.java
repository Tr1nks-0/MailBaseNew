package com.tr1nksgroup.model.entities;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Специализация
 * 6.04.051.[010].17.01
 */
@Entity
@Table(name = "specialization")
@SequenceGenerator(name = "specialization_seq", sequenceName = "specialization_id_seq", initialValue = 1, allocationSize = 1)

public class SpecializationEntity  implements Serializable {
    /**
     * id сущности
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "specialization_seq")
    @Column(name = "id", nullable = false)
    private long id;
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
    @Column(name = "name", nullable = false, length = 90)
    private String name;
    /**
     * специальность группы
     * 6.04.[051].010.17.01
     */
    @Basic
    @ManyToOne
    @JoinColumn(name = "speciality_id", referencedColumnName = "id", nullable = false)
    private SpecialityEntity specialityEntity;

    public SpecializationEntity(int specializationId, String name, SpecialityEntity specialityEntity) {
        this.specializationId = specializationId;
        this.name = name;
        this.specialityEntity = specialityEntity;
    }

    private SpecializationEntity() {
    }

    //region get-set

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
