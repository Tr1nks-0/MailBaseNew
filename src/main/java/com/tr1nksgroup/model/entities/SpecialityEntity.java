package com.tr1nksgroup.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Специальность
 * 6.04.[051].010.17.01
 */
@Entity
@Table(name = "speciality")
@SequenceGenerator(name = "speciality_seq", sequenceName = "speciality_id_seq", initialValue = 1, allocationSize = 1)
public class SpecialityEntity  implements Serializable {
    /**
     * id сущности
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "speciality_seq")
    @Column(name = "id", nullable = false)
    private long id;
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
    @Column(name = "name", nullable = false, length = 90)
    private String name;
    @OneToMany(mappedBy = "specialityEntity")
    private List<SpecializationEntity> specializationEntities;

    public SpecialityEntity(int specialityId, String name) {
        this.specialityId = specialityId;
        this.name = name;
    }

    private SpecialityEntity() {
    }

    //region get-set

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public List<SpecializationEntity> getSpecializationEntities() {
        return specializationEntities;
    }

    public void setSpecializationEntities(List<SpecializationEntity> specializationEntities) {
        this.specializationEntities = specializationEntities;
    }
    //endregion
}
