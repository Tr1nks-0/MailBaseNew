package com.tr1nksgroup.model.models.person.student;

import com.tr1nksgroup.model.entities.StudentEntity;
import com.tr1nksgroup.model.models.enums.person.TableRowStyleClass;

public class StudentEntityWrapper {
    private Boolean checked = false;
    private StudentEntity studentEntity;
    private TableRowStyleClass rowStyle = TableRowStyleClass.DEFAULT;
//    private TableRowStyleClass errorCellStyle = TableRowStyleClass.DANGER;
    private Integer errorIndex;
    private String errorMessage;

    public StudentEntityWrapper(StudentEntity studentEntity, Integer errorIndex, String errorMessage, TableRowStyleClass rowStyle) {
        this(studentEntity, rowStyle);
        this.errorIndex = errorIndex;
        this.errorMessage = errorMessage;
    }

    public StudentEntityWrapper(StudentEntity studentEntity, TableRowStyleClass rowStyle) {
        this(studentEntity);
        this.rowStyle = rowStyle;
    }

    public StudentEntityWrapper(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public StudentEntityWrapper() {
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public TableRowStyleClass getRowStyle() {
        return rowStyle;
    }

    public void setRowStyle(TableRowStyleClass rowStyle) {
        this.rowStyle = rowStyle;
    }

    public Integer getErrorIndex() {
        return errorIndex;
    }

    public void setErrorIndex(Integer errorIndex) {
        this.errorIndex = errorIndex;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
