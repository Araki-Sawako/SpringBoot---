package com.college.yi.bookmanager.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.yi.bookmanager.model.Book;
import com.college.yi.bookmanager.repository.Repository;

@Service
public class BookService{
    private Repository repository;

	public List<Book> getAllBooks() {
        List<Book> books=new ArrayList<>();
        
        books.add(new Book(1L, "変な家２", "雨穴", "飛鳥新社", LocalDate.of(2023, 3, 15), 11));
        books.add(new Book(2L, "大ピンチずかん２", "鈴木のりたけ", "小学館", LocalDate.of(2024, 1, 20), 13));
        books.add(new Book(3L, "成瀬は天下を取りにいく", "宮島未奈", "新潮社", LocalDate.of(2022, 6, 1), 17));
        books.add(new Book(4L, "大ピンチずかん", "鈴木のりたけ", "小学館", LocalDate.of(2021, 11, 10), 19));
        books.add(new Book(5L, "変な家", "雨穴", "飛鳥新社", LocalDate.of(2024, 9, 5), 23));
        
        return books;
        }

    
	@Autowired
	public void Service(Repository repository) {
		this.repository=repository;
	}
	
	public List<Book> getAllBooks1(){
		return ((BookService) repository).getAllBooks();
	}


}
