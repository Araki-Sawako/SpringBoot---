package com.management.task.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value="/hello")
    String hello(Model model) {
    	model.addAttribute("time",LocalDateTime.now());
    	return "hello";
    }

}