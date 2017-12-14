package com.tr1nksgroup.model.models.person.student;

import com.tr1nksgroup.model.entities.StudentEntity;
import com.tr1nksgroup.model.models.Model;

import java.util.List;

public class StudentModel implements Model {
    private List<StudentEntity> students;

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }
}
