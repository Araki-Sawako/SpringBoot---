package com.college.yi.bookmanager.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.college.yi.bookmanager.entity.BookEntity;

//データベースとやり取りをするクラス

@Mapper
public interface Repository {
    List<BookEntity>findAll();

   BookEntity findById(@Param("id") Long id);
   int insert(BookEntity book);
   int update(BookEntity book);
   int deleteById(@Param("id")Long id);

}