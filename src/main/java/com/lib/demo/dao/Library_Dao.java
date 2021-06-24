package com.lib.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lib.demo.model.Book_Model;

public interface Library_Dao extends JpaRepository<Book_Model,Integer> {
	List<Book_Model> findByGenre(String genre);
}
