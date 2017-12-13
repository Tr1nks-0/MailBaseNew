package com.tr1nksgroup.model.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * абстрактная сущность
 */
//@Entity
//@Table(name = "abstrEntity")
public abstract class AbstrEntity {
    /**
     * id сущности
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    //region get-set
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    //endregion
}
