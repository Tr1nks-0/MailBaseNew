package com.tr1nksgroup.model.models.person.student;

import com.tr1nksgroup.model.models.MyModel;

import java.util.ArrayList;
import java.util.List;

public class StudentModel implements MyModel {
    private List<StudentEntityWrapper> studentList = new ArrayList<>();
    private String action;
    private Boolean showHiddenColumns=false;

    public StudentModel(List<StudentEntityWrapper> studentList) {
        this.studentList = studentList;
    }

    public StudentModel() {

    }

    public List<StudentEntityWrapper> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentEntityWrapper> studentList) {
        this.studentList = studentList;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Boolean getShowHiddenColumns() {
        return showHiddenColumns;
    }

    public void setShowHiddenColumns(Boolean showHiddenColumns) {
        this.showHiddenColumns = showHiddenColumns;
    }
}
