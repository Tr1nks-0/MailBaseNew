package com.tr1nksgroup.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/c/main"})
public class MainController implements AbstrCommonController {
    private static final String VIEW_NAME = VIEW_BASE + "main";

    @GetMapping
    public String get() {
        return VIEW_NAME;
    }
}
