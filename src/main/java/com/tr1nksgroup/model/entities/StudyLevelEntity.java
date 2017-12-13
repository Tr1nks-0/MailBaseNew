package com.tr1nksgroup.model.entities;

import javax.persistence.*;

/**
 * уровень обучения
 * [6].04.051.010.17.01
 */
@Entity
@Table(name = "studylevel")
public class StudyLevelEntity extends AbstrEntity {
    /**
     * шифр уровня обучения
     */
    @Basic
    @Column(name = "level_id", nullable = false, length = 3)
    private int level;
    /**
     * название уровня обучения
     */
    @Basic
    @Column(name = "name", nullable = false, length = 30)
    private String name;


    //region get-set
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion
}
