package com.college.yi.bookmanager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.yi.bookmanager.entity.BookEntity;
import com.college.yi.bookmanager.model.Book;
import com.college.yi.bookmanager.repository.Repository;
import com.college.yi.bookmanager.util.BookService;


@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    private Repository repository;

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return repository.findAll();
    }
    
    @PostMapping
    public String addBook(@ModelAttribute Book form, Model model) {
        bookService.createBook(form);
        model.addAttribute("message", "登録完了しました。");
        return "redirect:/books";
    }
    
@Controller
public class LoginController {

        @GetMapping("/login")
        public String loginPage() {
            return "login";
        }

        @GetMapping("/")
        public String home() {
            return "redirect:/books";
        }
    }

}



    
    
    
    