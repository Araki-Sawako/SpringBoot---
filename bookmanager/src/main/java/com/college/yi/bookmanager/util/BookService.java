package com.college.yi.bookmanager.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.college.yi.bookmanager.Mapper.UserMapper;
import com.college.yi.bookmanager.entity.BookEntity;
import com.college.yi.bookmanager.entity.User;
import com.college.yi.bookmanager.model.Book;
import com.college.yi.bookmanager.repository.Repository;

@Service
public class BookService{
    private Repository repository;
	
   @Autowired
    public BookService(Repository repository) {
        this.repository = repository;
    }

    public List<Book>getAllBooks2(){  //DBから取得（本番用）
        List<BookEntity>entities =repository.findAll();
        if (entities.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "書籍が存在しません");
        }

        return entities.stream().map(entity -> new Book(
                entity.getId(),
                entity.getTitle(),
                entity.getAuthor(),
                entity.getPublisher(),
                entity.getPublishedDate(),
                entity.getStock()
                )).collect(Collectors.toList());
    }

    	//Bookの作成
    	public Book createBook(Book book) {
        BookEntity entity = new BookEntity();
        	entity.setTitle(book.getTitle());
        	entity.setAuthor(book.getAuthor());
        	entity.setPublisher(book.getPublisher());
        	entity.setPublishedDate(book.getPublishedDate());
        	entity.setStock(book.getStock());

        repository.insert(entity);
        return new Book(
                entity.getId(),
                entity.getTitle(),
                entity.getAuthor(),
                entity.getPublisher(),
                entity.getPublishedDate(),
                entity.getStock()
                );
    }

    //エラーの返却
    public Book updateBook(Long id, Book book) {
        BookEntity existing = repository.findById(id);
        if (existing == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "書籍が存在しません");
        }

        //
        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setPublisher(book.getPublisher());
        existing.setPublishedDate(book.getPublishedDate());
        existing.setStock(book.getStock());

        int updated = repository.update(existing);
        if (updated != 1) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "更新に失敗しました");
        }

        return new Book(
            existing.getId(),
            existing.getTitle(),
            existing.getAuthor(),
            existing.getPublisher(),
            existing.getPublishedDate(),
            existing.getStock()
        );
    }

    	//削除メソッド
        public void deleteBook(Long id) {
            BookEntity existing = repository.findById(id);
            if (existing == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "書籍が存在しません");
            }
            int deleted = repository.deleteById(id);    
            if (deleted != 1) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "削除に失敗しました");
            }
    }
        @Autowired
        private UserMapper userMapper;
        
        public User getUserByUsername(String username) {
        	return userMapper.findByUsername(username);
        }


}
