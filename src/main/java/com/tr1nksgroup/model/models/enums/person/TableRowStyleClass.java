package com.tr1nksgroup.model.models.enums.person;

public enum TableRowStyleClass {
    DEFAULT,
    ACTIVE,
    SUCCESS,
    INFO,
    WARNING,
    DANGER;

    public String toStyleClass() {
        return this.name().toLowerCase();
    }
}
