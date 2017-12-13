package com.tr1nksgroup.controller.common;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/index", "/"})
public class IndexController implements AbstrCommonController{
    private static final String VIEW_NAME = VIEW_BASE + "index";

    @GetMapping
    public String get() {
        return VIEW_NAME;
    }
}

