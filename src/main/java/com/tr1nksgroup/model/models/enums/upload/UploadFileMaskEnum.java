package com.tr1nksgroup.model.models.enums.upload;

import com.tr1nksgroup.model.models.upload.UploadModel;

/**
 * маски файла для {@link UploadModel PageData}
 */
public enum UploadFileMaskEnum {
    /**
     * Фамилия
     */
    SURNAME("Фамилия"),
    /**
     * Имя
     */
    NAME("Имя"),
    /**
     * Отчество
     */
    PATRONYMIC("Отчество"),
    /**
     * Код
     */
    CODE("Код"),
    /**
     * Группа или Кафедра
     */
    GROUP_OR_CATHEDRA("Группа/Кафедра"),
    /**
     * Бюджет или ставка
     */
    BUDGET_OR_RATE("Бюджет");

    private String value;

    /**
     * конструктор
     *
     * @param value значение
     */
    UploadFileMaskEnum(String value) {
        this.value = value;
    }

    /**
     * все значения enum
     *
     * @return все значения enum
     */
    public static UploadFileMaskEnum[] valuesW() {
        return values();
    }

    /**
     * получить значение маски
     *
     * @return значение маски
     */
    public String getValue() {
        return value;
    }
}
