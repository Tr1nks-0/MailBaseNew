package com.tr1nksgroup.model.engines;

import com.tr1nksgroup.model.components.LoginPasswordUtil;
import com.tr1nksgroup.model.models.filters.FilterPair;
import com.tr1nksgroup.model.models.enums.person.TableColumnIndexes;
import com.tr1nksgroup.model.models.enums.person.TableRowStyleClass;
import com.tr1nksgroup.model.models.filters.FilterItem;
import com.tr1nksgroup.model.models.filters.FilterModel;
import com.tr1nksgroup.model.models.person.student.StudentEntityTableWrapper;
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


    public boolean uploadRepeat(StudentModel studentModel) {
        final boolean[] f = {true};
        studentModel.getStudentEntityTableWrappers().stream().filter(StudentEntityTableWrapper::getChecked).forEach(studentEntityTableWrapper -> {
            if (studentService.testCode(studentEntityTableWrapper.getStudentEntity().getCode())) {
                studentEntityTableWrapper.setStudentEntity(studentService.save(studentEntityTableWrapper.getStudentEntity()));
                studentEntityTableWrapper.setRowStyle(TableRowStyleClass.SUCCESS);
                studentEntityTableWrapper.setChecked(false);
                studentEntityTableWrapper.setReadonly(true);
            } else {
                studentEntityTableWrapper.setChecked(true);
                studentEntityTableWrapper.setReadonly(false);
                studentEntityTableWrapper.setCellMessageAndStyleAndRowStyle(TableColumnIndexes.CODE, "Такой код ЕДБО уже есть в Базе Данных", TableRowStyleClass.DANGER, TableRowStyleClass.WARNING);
                f[0] = false;
            }
        });
        if (!f[0]) {
            studentModel.setShowHiddenColumns(true);
        }
        return f[0];
    }

    public FilterModel getFilterModel() {
        FilterModel model = new FilterModel();
        List<FilterItem> facultyList = new ArrayList<>();
        facultyService.getAll().forEach(facultyEntity -> facultyList.add(new FilterItem(facultyEntity.getId(), facultyEntity.getName(), facultyEntity.getAbbr())));
        model.addFilterListPair(new FilterPair("Факультет", facultyList));
        return model;
    }

    public StudentModel getTest() {
        List<StudentEntityTableWrapper> list = new ArrayList<>();
        studentService.getAll().forEach(studentEntity -> list.add(new StudentEntityTableWrapper(studentEntity)));
        return new StudentModel(list);
    }
}
