package com.tr1nksgroup.model.models.enums.person;

public enum TableRowStyleClass {
    /**
     * цвет фона
     */
    DEFAULT,
    /**
     * цвет выделенной строки
     */
    ACTIVE,
    /**
     * зеленый
     */
    SUCCESS,
    /**
     * голубой
     */
    INFO,
    /**
     * оранжевый
     */
    WARNING,
    /**
     * красный
     */
    DANGER;

    public String toStyleClass() {
        return this.name().toLowerCase();
    }
}
