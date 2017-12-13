package com.tr1nksgroup.model.entities;

import javax.persistence.*;

/**
 * абстрактная сущность
 */
@Entity
@Table(name = "abstr_entity")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "entity_seq", sequenceName = "entity_id_seq", initialValue = 1, allocationSize = 1)
public abstract class AbstrEntity {
    /**
     * id сущности
     */
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_seq")
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
