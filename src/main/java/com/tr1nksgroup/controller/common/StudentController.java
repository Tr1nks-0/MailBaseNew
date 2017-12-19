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
        StudentModel studentModel =studentEngine.getTest();
        model.addAttribute("studentModel", studentModel);
        return VIEW_NAME;
    }

    @PostMapping(path = "test")
    public String post(Model model,@ModelAttribute StudentModel studentModel) {
        model.addAttribute("studentModel", studentModel);
        return VIEW_NAME;
    }
}
