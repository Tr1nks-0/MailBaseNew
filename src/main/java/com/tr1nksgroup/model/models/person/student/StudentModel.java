package com.tr1nksgroup.model.models.person.student;

import com.tr1nksgroup.model.entities.StudentEntity;
import com.tr1nksgroup.model.models.MyModel;

import java.util.ArrayList;
import java.util.List;

public class StudentModel implements MyModel {
    List<StudentEntity> studentList = new ArrayList<>();

    public StudentModel(List<StudentEntity> studentList) {
        this.studentList = studentList;
    }

    public StudentModel() {

    }

    public List<StudentEntity> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentEntity> studentList) {
        this.studentList = studentList;
    }
}
