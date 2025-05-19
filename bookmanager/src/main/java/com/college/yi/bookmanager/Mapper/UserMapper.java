package com.college.yi.bookmanager.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.college.yi.bookmanager.entity.User;

@Mapper
public interface UserMapper {
	
	User findById(@Param("id") Long id);
	User findByUsername(@Param("username") String username);
	List<User> findAll();
	void insert(User user);
	void update(User user);
	void delete(@Param("id") Long id);

}
