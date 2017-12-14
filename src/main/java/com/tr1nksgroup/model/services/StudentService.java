package com.tr1nksgroup.model.services;

import com.tr1nksgroup.model.entities.StudentEntity;

public interface StudentService {
    boolean testEmail(String s);

    boolean testCode(String s);

    StudentEntity save(StudentEntity student);
}
