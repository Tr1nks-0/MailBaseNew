package com.tr1nksgroup.model.entities;

import javax.persistence.*;

/**
 * домены для учетных записей
 * таблица должна содержать одну запись со всеми доменами
 */
@Entity
@Table(name = "domens")
public class DomensEntity extends AbstrEntity {
    /**
     * домен для почты
     */
    @Basic
    @Column(name = "email", nullable = false, length = 50)
    private String emailDomen;
    /**
     * домен для imagine
     */
    @Basic
    @Column(name = "imagine", nullable = false, length = 50)
    private String imagineDomen;
    /**
     * домен для office
     */
    @Basic
    @Column(name = "office", nullable = false, length = 50)
    private String officeDomen;

    //region get-set

    /**
     * получить домен для почты
     *
     * @return домен для почты
     */
    public String getEmailDomen() {
        return emailDomen;
    }

    /**
     * установить домен для почты
     *
     * @param emailDomen домен для почты
     */
    public void setEmailDomen(String emailDomen) {
        this.emailDomen = emailDomen;
    }

    /**
     * получить домен для imagine
     *
     * @return домен для imagine
     */
    public String getImagineDomen() {
        return imagineDomen;
    }

    /**
     * установить домен для imagine
     *
     * @param imagineDomen домен для imagine
     */
    public void setImagineDomen(String imagineDomen) {
        this.imagineDomen = imagineDomen;
    }

    /**
     * получить домен для office
     *
     * @return домен для office
     */
    public String getOfficeDomen() {
        return officeDomen;
    }

    /**
     * установить домен для office
     *
     * @param officeDomen домен для office
     */
    public void setOfficeDomen(String officeDomen) {
        this.officeDomen = officeDomen;
    }
    //endregion
}
