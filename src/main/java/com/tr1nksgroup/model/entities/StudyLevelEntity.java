package com.tr1nksgroup.model.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * уровень обучения
 * [6].04.051.010.17.01
 */
@Entity
@Table(name = "studylevel")
public class StudyLevelEntity implements Serializable {
    /**
     * id сущности
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    /**
     * шифр уровня обучения
     */
    @Basic
    @Column(name = "level_id", nullable = false, length = 3)
    private int levelId;
    /**
     * название уровня обучения
     */
    @Basic
    @Column(name = "name", nullable = false, length = 30)
    private String name;

    public StudyLevelEntity(int id, String name) {
        this.levelId = id;
        this.name = name;
    }

    private StudyLevelEntity() {
    }

    //region get-set

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion
}
