package com.tr1nksgroup.model.entities.enums;

public enum SiteRolesEnum {
    /**
     * администратор
     */
    ADMIN,
    /**
     * пользователь
     */
    USER;


    /**
     * получить строку роли
     *
     * @return строка роли
     */
    public String getRoleWithPrefix() {
        return "ROLE_" + this.name();
    }

    /**
     * получить строку роли без приписки "ROLE_"
     *
     * @return строка роли
     */
    public String getRole() {
        return this.name();
    }
}
