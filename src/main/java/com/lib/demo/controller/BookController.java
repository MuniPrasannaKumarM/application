package com.lib.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lib.demo.dao.Library_Dao;
import com.lib.demo.model.Book_Model;


@RestController
public class BookController {

	@Autowired
	private Library_Dao repo;
	
	@PostMapping("/saveBook")
	@ResponseBody
	public String saveBook(@RequestBody Book_Model model)
	{
		
		repo.save(model);
		return "Inserted";
	}
	@GetMapping("/getBooks")
	@ResponseBody
	public List<Book_Model> getBooks()
	{
		return repo.findAll();
	}
	@DeleteMapping("/deleteBook/{bookId}")
	public String deleteAlien(@PathVariable("bookId") int bookId) {
		
		Book_Model a1 = repo.getById(bookId);
		
		repo.delete(a1);
		return "Deleted";
	}
	@PutMapping("/editBook/{bookId}")
	@ResponseBody
	public String saveBook(@PathVariable int bookId, @RequestBody Book_Model model)
	{
		repo.save(model);
		return "Inserted";
	}
	@GetMapping("/getByType/{genre}")
	@ResponseBody
	public List<Book_Model> getByType(@PathVariable("genre") String genre)
	{
		return repo.findByGenre(genre);
	}

	
}
