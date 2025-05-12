package com.college.yi.bookmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.college.yi.bookmanager.util.BookService;

public class BookControllerHTML {
	
    @Autowired
    private BookService bookService;
    @GetMapping("/books")
    public String showBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "index";
    }

}
