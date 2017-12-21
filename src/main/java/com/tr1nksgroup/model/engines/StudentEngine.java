package com.tr1nksgroup.model.engines;

import com.tr1nksgroup.model.components.LoginPasswordUtil;
import com.tr1nksgroup.model.models.enums.person.TableColumnIndexes;
import com.tr1nksgroup.model.models.enums.person.TableRowStyleClass;
import com.tr1nksgroup.model.models.person.student.StudentEntityWrapper;
import com.tr1nksgroup.model.models.person.student.StudentModel;
import com.tr1nksgroup.model.services.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
        List<StudentEntityWrapper> list = new ArrayList<>();
        studentService.getAll().forEach(studentEntity -> list.add(new StudentEntityWrapper(studentEntity)));
        return new StudentModel(list);
    }

    public boolean uploadRepeat(StudentModel studentModel) {
        final boolean[] f = {true};
        studentModel.getStudentEntityWrappers().stream().filter(StudentEntityWrapper::getChecked).forEach(studentEntityWrapper -> {
            if (studentService.testCode(studentEntityWrapper.getStudentEntity().getCode())) {
                studentEntityWrapper.setStudentEntity(studentService.save(studentEntityWrapper.getStudentEntity()));
                studentEntityWrapper.setRowStyle(TableRowStyleClass.SUCCESS);
                studentEntityWrapper.setChecked(false);
                studentEntityWrapper.setReadonly(true);
            } else {
                studentEntityWrapper.setChecked(true);
                studentEntityWrapper.setReadonly(false);
                studentEntityWrapper.setCellMessageAndStyleAndRowStyle(TableColumnIndexes.CODE, "Такой код ЕДБО уже есть в Базе Данных", TableRowStyleClass.DANGER, TableRowStyleClass.WARNING);
                f[0] = false;
            }
        });
        if (!f[0]) {
            studentModel.setShowHiddenColumns(true);
        }
        return f[0];
    }
}
