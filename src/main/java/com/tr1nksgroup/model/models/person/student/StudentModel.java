package com.tr1nksgroup.model.models.person.student;

import com.tr1nksgroup.model.models.MyModel;

import java.util.ArrayList;
import java.util.List;

public class StudentModel implements MyModel {
    private List<StudentEntityTableWrapper> studentEntityTableWrappers = new ArrayList<>();
    private Boolean showHiddenColumns=false;

    public StudentModel(List<StudentEntityTableWrapper> studentEntityTableWrappers) {
        this.studentEntityTableWrappers = studentEntityTableWrappers;
    }

    public StudentModel() {

    }

    public List<StudentEntityTableWrapper> getStudentEntityTableWrappers() {
        return studentEntityTableWrappers;
    }

    public void setStudentEntityTableWrappers(List<StudentEntityTableWrapper> studentEntityTableWrappers) {
        this.studentEntityTableWrappers = studentEntityTableWrappers;
    }

    public Boolean getShowHiddenColumns() {
        return showHiddenColumns;
    }

    public void setShowHiddenColumns(Boolean showHiddenColumns) {
        this.showHiddenColumns = showHiddenColumns;
    }
}
