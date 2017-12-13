package com.tr1nksgroup.model.entities;

import javax.persistence.*;

/**
 * студент
 */
@Entity
@Table(name = "student")
public class StudentEntity extends PersonEntity {
    /**
     * группа к которой принадлежит студент
     */
    @Basic
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    private GroupEntity group;
    /**
     * флаг о наличии бюджета
     */
    @Basic
    @Column(name = "budget", nullable = false, columnDefinition = "bit(1) default false")
    private boolean budget;

    //region get-set
    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    public boolean isBudget() {
        return budget;
    }

    public void setBudget(boolean budget) {
        this.budget = budget;
    }
    //endregion
}
