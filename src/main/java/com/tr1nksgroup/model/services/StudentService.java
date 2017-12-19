package com.tr1nksgroup.model.services;

import com.tr1nksgroup.model.entities.StudentEntity;

import java.util.List;

public interface StudentService {
    boolean testEmail(String s);

    boolean testCode(String s);

    StudentEntity save(StudentEntity student);

    List<StudentEntity> getAll();
}
