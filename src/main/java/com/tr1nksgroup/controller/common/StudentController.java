package com.tr1nksgroup.controller.common;

import com.tr1nksgroup.model.engines.StudentEngine;
import com.tr1nksgroup.model.models.person.student.StudentModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping({"/c/student"})
public class StudentController implements CommonController {
    private static final String VIEW_NAME = VIEW_BASE + "student";
    @Resource
    private StudentEngine studentEngine;

    @GetMapping
    public String get(Model model) {
        StudentModel studentModel = studentEngine.getTest();//fixme
        model.addAttribute("studentModel", studentModel);
        return VIEW_NAME;
    }


    @PostMapping(path = "postUploadErrors")
    public String postUploadErrors(Model model, @ModelAttribute("studentModel") StudentModel studentModel) {
        if (null == studentModel.getAction()) {
            studentModel.setAction("errorEdit");
        }
        switch (studentModel.getAction()) {
            case "errorEditSubmit": {
                //todo re parse and see on result
                model.addAttribute("formAction", "/c/student");
                break;
            }
            default: {
                //here remap on this controller, no ad any messages or flags
                model.addAttribute("formAction", "/c/student/postUploadErrors");
                break;
            }
        }
        return VIEW_NAME;
    }

    @PostMapping
    public String post(Model model, @ModelAttribute("studentModel") StudentModel studentModel) {

//        StudentModel studentModelw = studentEngine.getTest();
//        studentModel.getStudentEntityWrappers().get(0).setRowStyle(TableRowStyleClass.WARNING);
//        studentModel.setShowHiddenColumns(true);
//        studentModel.getStudentEntityWrappers().get(0).setCellMessageAndStyle(TableColumnIndexes.NAME, "message test", TableRowStyleClass.DANGER);
//        studentModel.getStudentEntityWrappers().get(1).setCellMessageAndStyleAndRowStyle(TableColumnIndexes.GROUP_OR_CATHEDRA, "message test2222", TableRowStyleClass.ACTIVE, TableRowStyleClass.SUCCESS);

//        if(!model.containsAttribute("studentModel")){
//        model.addAttribute("studentModel", studentModel);//it is replace, don't needed, now for debug placed
//    }
        return VIEW_NAME;
    }
}
