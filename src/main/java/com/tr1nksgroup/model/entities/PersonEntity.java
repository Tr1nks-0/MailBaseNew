package com.tr1nksgroup.model.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Generic для преподавателя и студента
 */
@Entity
//@Table(name = "person")
@SequenceGenerator(name = "person_seq", sequenceName = "person_id_seq", initialValue = 1, allocationSize = 1)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PersonEntity implements Serializable {
    /**
     * id сущности
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    @Column(name = "id", nullable = false)
    private long id;
    /**
     * фамилия
     */
    @Basic
    @Column(name = "surname", nullable = false, length = 50)
    String surname;
    /**
     * имя
     */
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    String name;
    /**
     * отчество
     */
    @Basic
    @Column(name = "patronymic", nullable = true, length = 50)
    String patronymic;
    /**
     * код
     */
    @Basic
    @Column(name = "code", unique = true, nullable = false, length = 100)
    String code;
    /**
     * логин почты
     */
    @Basic
    @Column(name = "login", unique = true, nullable = true, length = 100)
    String login;
    /**
     * начальный пароль почты
     */
    @Basic
    @Column(name = "init_password", nullable = true, length = 15)
    String initPassword;
    /**
     * флаг о наличии аккаунта imagine
     */
    @Basic
    @Column(name = "imagine", nullable = false, columnDefinition = "bit(1) default false")
    boolean imagine;
    /**
     * флаг о наличии аккаунта office
     */
    @Basic
    @Column(name = "office", nullable = false, columnDefinition = "bit(1) default false")
    boolean office;

    /**
     * конструктор
     *
     * @param surname    фамилия
     * @param name       имя
     * @param patronymic отчество
     * @param code       код
     */
    public PersonEntity(String surname, String name, String patronymic, String code) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.code = code;
    }

    protected PersonEntity() {

    }

    //region get-set


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getInitPassword() {
        return initPassword;
    }

    public void setInitPassword(String initPassword) {
        this.initPassword = initPassword;
    }

    public boolean isImagine() {
        return imagine;
    }

    public void setImagine(boolean imagine) {
        this.imagine = imagine;
    }

    public boolean isOffice() {
        return office;
    }

    public void setOffice(boolean office) {
        this.office = office;
    }

    //endregion
}
