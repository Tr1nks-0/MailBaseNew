package com.tr1nksgroup.model.models.person.student;

import com.tr1nksgroup.model.entities.StudentEntity;
import com.tr1nksgroup.model.models.enums.person.TableColumnIndexes;
import com.tr1nksgroup.model.models.enums.person.TableRowStyleClass;

public class StudentEntityTableWrapper {
    private boolean checked = false;
    private boolean readonly = true;
    private StudentEntity studentEntity;
    private TableRowStyleClass rowStyle = TableRowStyleClass.DEFAULT;
    private int cellIndex;
    private TableRowStyleClass cellStyle = TableRowStyleClass.DEFAULT;
    private String message;

    public StudentEntityTableWrapper(StudentEntity studentEntity, int cellIndex, String message, TableRowStyleClass rowStyle, TableRowStyleClass cellStyle) {
        this(studentEntity, rowStyle);
        this.cellIndex = cellIndex;
        this.message = message;
        this.cellStyle = cellStyle;
    }

    public StudentEntityTableWrapper(StudentEntity studentEntity, TableRowStyleClass rowStyle) {
        this(studentEntity);
        this.rowStyle = rowStyle;
    }

    public StudentEntityTableWrapper(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public StudentEntityTableWrapper() {
    }

    //region get-set
    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean getReadonly() {
        return readonly;
    }

    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
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

    public int getCellIndex() {
        return cellIndex;
    }

    public void setCellIndex(int cellIndex) {
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

    public void setCellMessageAndStyle(TableColumnIndexes cellIndex, String message, TableRowStyleClass cellStyle) {
        this.cellIndex = cellIndex.index;
        this.message = message;
        this.cellStyle = cellStyle;
    }

    public void setCellMessageAndStyleAndRowStyle(TableColumnIndexes cellIndex, String message, TableRowStyleClass cellStyle, TableRowStyleClass rowStyle) {
        this.setCellMessageAndStyle(cellIndex, message, cellStyle);
        this.rowStyle = rowStyle;
    }

    public void setCellStyleAndRowStyle(TableColumnIndexes cellIndex, TableRowStyleClass cellStyle, TableRowStyleClass rowStyle) {
        this.cellIndex = cellIndex.index;
        this.cellStyle = cellStyle;
        this.rowStyle = rowStyle;

    }
    //endregion
}
