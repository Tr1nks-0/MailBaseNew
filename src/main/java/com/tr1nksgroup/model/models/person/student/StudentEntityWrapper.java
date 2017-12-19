package com.tr1nksgroup.model.models.person.student;

import com.tr1nksgroup.model.entities.StudentEntity;
import com.tr1nksgroup.model.models.enums.person.TableRowStyleClass;

public class StudentEntityWrapper {
    private Boolean checked = false;
    private StudentEntity studentEntity;
    private TableRowStyleClass rowStyle = TableRowStyleClass.DEFAULT;
    private Integer cellIndex;
    private TableRowStyleClass cellStyle = TableRowStyleClass.DEFAULT;
    private String message;

    public StudentEntityWrapper(StudentEntity studentEntity, Integer cellIndex, String message, TableRowStyleClass rowStyle, TableRowStyleClass cellStyle) {
        this(studentEntity, rowStyle);
        this.cellIndex = cellIndex;
        this.message = message;
        this.cellStyle = cellStyle;
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

    //region get-set
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

    public Integer getCellIndex() {
        return cellIndex;
    }

    public void setCellIndex(Integer cellIndex) {
        this.cellIndex = cellIndex;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TableRowStyleClass getCellStyle() {
        return cellStyle;
    }

    public void setCellStyle(TableRowStyleClass cellStyle) {
        this.cellStyle = cellStyle;
    }

    public void setCellStyle(int id, TableRowStyleClass cellStyle) {
        this.cellIndex = id;
        this.cellStyle = cellStyle;
    }
    //endregion
}
