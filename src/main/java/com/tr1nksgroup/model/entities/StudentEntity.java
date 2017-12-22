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
    private GroupEntity groupEntity;
    /**
     * флаг о наличии бюджета
     */
    @Basic
    @Column(name = "budget", nullable = false, columnDefinition = "bit(1) default false")
    private boolean budget;

    /**
     * конструктор
     *
     * @param surname    фамилия
     * @param name       имя
     * @param patronymic отчество
     * @param code       код
     * @param groupEntity      группа к которой принадлежит студент
     * @param login      логин почты
     * @param passw      начальный пароль почты
     * @param budget     флаг о наличии бюджета
     */
    public StudentEntity(String surname, String name, String patronymic, String code, GroupEntity groupEntity, String login, String passw, boolean budget) {
        this(surname, name, patronymic, code, groupEntity);
        this.login = login;
        this.initPassword = passw;
        this.budget = budget;
    }

    /**
     * конструктор
     *
     * @param surname    фамилия
     * @param name       имя
     * @param patronymic отчество
     * @param code       код
     * @param groupEntity      группа к которой принадлежит студент
     */
    public StudentEntity(String surname, String name, String patronymic, String code, GroupEntity groupEntity) {
        super(surname, name, patronymic, code);
        this.groupEntity = groupEntity;
    }

    public StudentEntity() {
        super();
    }

    //region get-set
    public GroupEntity getGroupEntity() {
        return groupEntity;
    }

    public void setGroupEntity(GroupEntity groupEntity) {
        this.groupEntity = groupEntity;
    }

    public boolean isBudget() {
        return budget;
    }

    public void setBudget(boolean budget) {
        this.budget = budget;
    }
    //endregion
}
