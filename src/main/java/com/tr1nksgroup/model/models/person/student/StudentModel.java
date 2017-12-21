package com.tr1nksgroup.model.models.person.student;

import com.tr1nksgroup.model.models.MyModel;

import java.util.ArrayList;
import java.util.List;

public class StudentModel implements MyModel {
    private List<StudentEntityWrapper> studentEntityWrappers = new ArrayList<>();
    private Boolean showHiddenColumns=false;

    public StudentModel(List<StudentEntityWrapper> studentEntityWrappers) {
        this.studentEntityWrappers = studentEntityWrappers;
    }

    public StudentModel() {

    }

    public List<StudentEntityWrapper> getStudentEntityWrappers() {
        return studentEntityWrappers;
    }

    public void setStudentEntityWrappers(List<StudentEntityWrapper> studentEntityWrappers) {
        this.studentEntityWrappers = studentEntityWrappers;
    }

    public Boolean getShowHiddenColumns() {
        return showHiddenColumns;
    }

    public void setShowHiddenColumns(Boolean showHiddenColumns) {
        this.showHiddenColumns = showHiddenColumns;
    }
}
