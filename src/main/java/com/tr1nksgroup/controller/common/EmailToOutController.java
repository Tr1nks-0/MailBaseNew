package com.tr1nksgroup.controller.common;

import com.tr1nksgroup.model.engines.EmailToOutEngine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping({"/emailToOutController", "/EmailToOutController"})//EmailToOutController --backward capability
public class EmailToOutController {
    @Resource
    private EmailToOutEngine emailToOutEngine;

    @GetMapping
    public void get(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("groupId") String groupId, HttpServletResponse response) {
        try {
            response.getWriter().write(emailToOutEngine.get(name, surname, groupId));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}