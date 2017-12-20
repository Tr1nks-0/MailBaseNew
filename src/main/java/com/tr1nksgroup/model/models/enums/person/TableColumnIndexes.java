package com.tr1nksgroup.model.models.enums.person;

public enum TableColumnIndexes {
    NUM(0),
    SURNAME(1),
    NAME(2),
    PATRONYMIC(3),
    GROUP_OR_CATHEDRA(4),
    CODE(5),
    LOGIN(6),
    INIT_PASSW(7),
    BUDGET_OR_RATE(8),
    IMAGINE(9),
    OFFICE(10);

    public final int index;

    TableColumnIndexes(int index) {
        this.index = index;
    }
}
