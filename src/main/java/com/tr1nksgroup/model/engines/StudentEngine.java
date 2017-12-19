package com.tr1nksgroup.model.engines;

import com.tr1nksgroup.model.components.LoginPasswordUtil;
import com.tr1nksgroup.model.models.person.student.StudentModel;
import com.tr1nksgroup.model.services.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StudentEngine {
    @Resource
    private StudentService studentService;
    @Resource
    private GroupService groupService;
    @Resource
    private FacultyService facultyService;
    @Resource
    private StudyLevelService studyLevelService;
    @Resource
    private SpecialityService specialityService;
    @Resource
    private SpecializationService specializationService;
    @Resource
    private WorkSessionService workSessionService;
    @Resource
    private LoginPasswordUtil loginPasswordUtil;


    public StudentModel getTest() {
        return new StudentModel(studentService.getAll());
    }
}
