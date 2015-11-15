package com.kritacademy.projects.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Chertpong on 13/11/2558.
 */
@Controller
public class HomeController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String get(){
        return "index.html";
    }
}
