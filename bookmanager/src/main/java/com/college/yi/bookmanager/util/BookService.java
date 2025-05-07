package com.college.yi.bookmanager.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.college.yi.bookmanager.model.Book;

@Service
public class BookService{
    public List<Book> getAllBooks() {
        List<Book> book=new ArrayList<>();
        
        book.add(new Book(1, "変な家２", "雨穴", "飛鳥新社", LocalDate.of(2023, 3, 15), 11));
        book.add(new Book(2, "大ピンチずかん２", "鈴木のりたけ", "小学館", LocalDate.of(2024, 1, 20), 13));
        book.add(new Book(3, "成瀬は天下を取りにいく", "宮島未奈", "新潮社", LocalDate.of(2022, 6, 1), 17));
        book.add(new Book(4, "大ピンチずかん", "鈴木のりたけ", "小学館", LocalDate.of(2021, 11, 10), 19));
        book.add(new Book(5, "変な家", "雨穴", "飛鳥新社", LocalDate.of(2024, 9, 5), 23));
        
        return book;
        }
}
