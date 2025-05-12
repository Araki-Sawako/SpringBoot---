package com.college.yi.bookmanager.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.yi.bookmanager.BookEntity;
import com.college.yi.bookmanager.model.Book;
import com.college.yi.bookmanager.repository.Repository;
import com.college.yi.bookmanager.util.BookService1;


@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService1 bookService;
    
    public BookController(BookService1 bookService) {
        this.bookService = bookService;
    }
    
    private Repository repository;

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return repository.findAll();
    }
    
    @GetMapping
    public String showBookPage(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "index";
    }

    @PostMapping
    public String addBook(@ModelAttribute Book form, Model model) {
        bookService.createBook(form);
        model.addAttribute("message", "登録完了しました！");
        return "redirect:/books";
    }
}



    
    
    
    