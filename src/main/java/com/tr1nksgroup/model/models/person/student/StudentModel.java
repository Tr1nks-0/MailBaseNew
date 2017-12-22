package com.tr1nksgroup.model.models.person.student;

import com.tr1nksgroup.model.models.MyModel;

import java.util.ArrayList;
import java.util.List;

public class StudentModel implements MyModel {
    private List<StudentEntityTableWrapper> studentEntityTableWrappers = new ArrayList<>();
    private boolean showHiddenColumns = false;

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

    public boolean getShowHiddenColumns() {
        return showHiddenColumns;
    }

    public void setShowHiddenColumns(boolean showHiddenColumns) {
        this.showHiddenColumns = showHiddenColumns;
    }
}
