package com.tr1nksgroup.model.models.person.student;

import com.tr1nksgroup.model.models.MyModel;

import java.util.ArrayList;
import java.util.List;

public class StudentModel implements MyModel {
    List<StudentEntityWrapper> studentList = new ArrayList<>();

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
}
