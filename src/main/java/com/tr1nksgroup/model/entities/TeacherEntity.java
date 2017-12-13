package com.tr1nksgroup.model.entities;


import javax.persistence.*;

/**
 * преподаватель
 */
@Entity
@Table(name = "teacher")
public class TeacherEntity extends PersonEntity {
    /**
     * кафедра к которой принадлежит преподаватель
     */
    @Basic
    @ManyToOne
    @JoinColumn(name = "cathedra_id", referencedColumnName = "id", nullable = false)
    private CathedraEntity cathedra;
    /**
     * ставка
     */
    @Basic
//    @Column(name = "rate", nullable = false, columnDefinition = "decimal(2,2) default 1.0")
    @Column(name = "rate", nullable = false)
    private double rate;


    //region get-set

    /**
     * получить кафедру к которой принадлежит преподаватель
     *
     * @return кафедра к которой принадлежит преподаватель
     */
    public CathedraEntity getCathedra() {
        return cathedra;
    }

    /**
     * установить кафедру к которой принадлежит преподаватель
     *
     * @param cathedra кафедра к которой принадлежит преподаватель
     */
    public void setCathedra(CathedraEntity cathedra) {
        this.cathedra = cathedra;
    }

    /**
     * получить ставку
     *
     * @return ставка
     */
    public double getRate() {
        return rate;
    }

    /**
     * установить ставку
     *
     * @param rate ставка
     */
    public void setRate(double rate) {
        this.rate = rate;
    }
    //endregion
}
