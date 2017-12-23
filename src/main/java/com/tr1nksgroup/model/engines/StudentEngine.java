package com.tr1nksgroup.model.engines;

import com.tr1nksgroup.model.components.LoginPasswordUtil;
import com.tr1nksgroup.model.entities.StudentEntity;
import com.tr1nksgroup.model.models.enums.person.TableColumnIndexes;
import com.tr1nksgroup.model.models.enums.person.TableRowStyleClass;
import com.tr1nksgroup.model.models.filters.FilterItem;
import com.tr1nksgroup.model.models.filters.FilterModel;
import com.tr1nksgroup.model.models.filters.FilterPair;
import com.tr1nksgroup.model.models.person.student.StudentEntityTableWrapper;
import com.tr1nksgroup.model.models.person.student.StudentModel;
import com.tr1nksgroup.model.services.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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
        List<FilterItem> groupList = new ArrayList<>();
        List<FilterItem> yearList = new ArrayList<>();
//        long yearI
        facultyService.getAll().forEach(facultyEntity -> facultyList.add(new FilterItem(facultyEntity.getId(), facultyEntity.getName(), facultyEntity.getAbbr())));
        groupService.getAll().forEach(groupEntity -> {
            groupList.add(new FilterItem(groupEntity.getId(), groupEntity.getCipher()));
            if (yearList.stream().noneMatch(filterItem -> filterItem.getName().equals(String.valueOf(groupEntity.getYear())))) {
                yearList.add(new FilterItem(0, String.valueOf(groupEntity.getYear())));
            }
        });

        model.addFilterListPair(new FilterPair("Факультет", 0, facultyList));
        model.addFilterListPair(new FilterPair("Группа", 1, groupList));
        model.addFilterListPair(new FilterPair("Год поступления", 2, yearList));
        return model;
    }

    public StudentModel getStudentsByFilters(FilterModel filterModel) {
        StudentModel model = new StudentModel();
        List<Long> facultyIds = filterModel.getFilterPairsList().stream()
                .filter(filterPair -> filterPair.getId() == 0).findFirst().orElse(new FilterPair()).getItemsList().stream()
                .filter(FilterItem::getChecked).mapToLong(FilterItem::getId).boxed().collect(Collectors.toList());

        List<Long> groupIds = filterModel.getFilterPairsList().stream()
                .filter(filterPair -> filterPair.getId() == 1).findFirst().orElse(new FilterPair()).getItemsList().stream()
                .filter(FilterItem::getChecked).mapToLong(FilterItem::getId).boxed().collect(Collectors.toList());

        List<Integer> years = filterModel.getFilterPairsList().stream()
                .filter(filterPair -> filterPair.getId() == 2).findFirst().orElse(new FilterPair()).getItemsList().stream()
                .filter(FilterItem::getChecked).mapToInt(value -> Integer.parseInt(value.getName())).boxed().collect(Collectors.toList());

        HashSet<StudentEntity> students = new HashSet<>();
        if (!facultyIds.isEmpty()) {
            students.addAll(studentService.getAllByFacultyIds(facultyIds));
        }
        if (!groupIds.isEmpty()) {
            students.addAll(studentService.getAllByGroupIds(groupIds));
        }
        if (!years.isEmpty()) {
            students.addAll(studentService.getAllByGroupYears(years));
        }
        students.forEach(studentEntity -> model.getStudentEntityTableWrappers().add(new StudentEntityTableWrapper(studentEntity)));
        if (model.getStudentEntityTableWrappers().isEmpty()) {
            return null;
        } else {
            return model;
        }
    }

    public StudentModel getTest() {
        List<StudentEntityTableWrapper> list = new ArrayList<>();
        studentService.getAll().forEach(studentEntity -> list.add(new StudentEntityTableWrapper(studentEntity)));
        return new StudentModel(list);
    }


    public void budgetSetRem(StudentModel studentModel, String action) {
        setRem(studentModel, action, (studentEntity, value) -> studentEntity.setBudget(value), TableColumnIndexes.BUDGET_OR_RATE);
    }

    public void imagineSetRem(StudentModel studentModel, String action) {
        setRem(studentModel, action, (studentEntity, value) -> studentEntity.setImagine(value), TableColumnIndexes.IMAGINE);
    }

    public void officeSetRem(StudentModel studentModel, String action) {
        setRem(studentModel, action, (studentEntity, value) -> studentEntity.setOffice(value), TableColumnIndexes.OFFICE);
    }

    private void setRem(StudentModel studentModel, String action, SetRemBackCall backCall, TableColumnIndexes columnId) {
        studentModel.getStudentEntityTableWrappers().stream().filter(StudentEntityTableWrapper::getChecked).forEach(wrapper -> {
            StudentEntity student = wrapper.getStudentEntity();
            backCall.call(student, action.equals("set"));
            wrapper.setStudentEntity(studentService.save(student));
            wrapper.setCellStyleAndRowStyle(columnId, TableRowStyleClass.SUCCESS, TableRowStyleClass.INFO);
        });
    }

    private interface SetRemBackCall {
        void call(StudentEntity studentEntity, boolean value);
    }

}
