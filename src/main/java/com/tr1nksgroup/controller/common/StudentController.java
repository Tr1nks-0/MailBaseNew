package com.tr1nksgroup.controller.common;

import com.tr1nksgroup.model.engines.StudentEngine;
import com.tr1nksgroup.model.models.person.student.StudentModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping({"/c/student"})
public class StudentController implements CommonController {
    private static final String VIEW_NAME = VIEW_BASE + "student";
    static final String UPLOAD_ERROR_FLAG_MODEL_MANE = "uploadError";
    private static final String STUDENT_MODEL_MANE = "studentModel";
    @Resource
    private StudentEngine studentEngine;

    @GetMapping
    public String get(Model model) {
        model.addAttribute(STUDENT_MODEL_MANE, studentEngine.getTest());//fixme for debug only
        return VIEW_NAME;
    }


    @PostMapping(path = "budget/{action}")
    public String postBudget(@PathVariable("action") String action, Model model, @ModelAttribute(STUDENT_MODEL_MANE) StudentModel studentModel) {
        //todo set rem budget
        return VIEW_NAME;
    }

    @PostMapping(path = "imagine/{action}")
    public String postImagine(@PathVariable("action") String action, Model model, @ModelAttribute(STUDENT_MODEL_MANE) StudentModel studentModel) {
        //todo set rem imagine
        return VIEW_NAME;
    }

    @PostMapping(path = "office/{action}")
    public String postOffice(@PathVariable("action") String action, Model model, @ModelAttribute(STUDENT_MODEL_MANE) StudentModel studentModel) {
        //todo set rem office
        return VIEW_NAME;
    }

    @PostMapping(path = "email")
    public String postEmail(Model model, @ModelAttribute(STUDENT_MODEL_MANE) StudentModel studentModel) {
        //todo send email
        return VIEW_NAME;
    }

    @PostMapping(path = "archives")
    public String postArchives(Model model, @ModelAttribute(STUDENT_MODEL_MANE) StudentModel studentModel) {
        //todo get archives
        return VIEW_NAME;
    }

    @PostMapping(path = "upload/repeat")
    public String post(Model model, @ModelAttribute(STUDENT_MODEL_MANE) StudentModel studentModel) {
        model.addAttribute(UPLOAD_ERROR_FLAG_MODEL_MANE, !studentEngine.uploadRepeat(studentModel));
        return VIEW_NAME;
    }
//        StudentModel studentModelw = studentEngine.getTest();
//        studentModel.getStudentEntityWrappers().get(0).setRowStyle(TableRowStyleClass.WARNING);
//        studentModel.setShowHiddenColumns(true);
//        studentModel.getStudentEntityWrappers().get(0).setCellMessageAndStyle(TableColumnIndexes.NAME, "message test", TableRowStyleClass.DANGER);
//        studentModel.getStudentEntityWrappers().get(1).setCellMessageAndStyleAndRowStyle(TableColumnIndexes.GROUP_OR_CATHEDRA, "message test2222", TableRowStyleClass.ACTIVE, TableRowStyleClass.SUCCESS);

//        if(!model.containsAttribute(STUDENT_MODEL_MANE)){
//        model.addAttribute(STUDENT_MODEL_MANE, studentModel);//it is replace, don't needed, now for debug placed
//    }
}
