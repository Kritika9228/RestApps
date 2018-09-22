package com.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.exception.BookNotFoundException;
import com.rest.model.Book;
import com.rest.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {
	private static final Logger LOGGER =LoggerFactory.getLogger(BookController.class);
	private static final String CLASSNAME = "BookController";
	@Autowired
	private BookService bookSer;
	
	@RequestMapping(value="/Books", method = RequestMethod.GET)
	public List<Book> getAllbooks() {
		LOGGER.info("Inside Controller::"+ CLASSNAME + " Method:: getAllbooks()" );
		return bookSer.getAllbooks();
	}
	
	@RequestMapping(value="/Book/{bookId}", method = RequestMethod.GET)
	public Book getbook(@PathVariable int bookId) throws BookNotFoundException {
		LOGGER.info("Inside Controller::"+ CLASSNAME + " Method:: getbook()" );
		Book b = new Book();
		try {
		b=bookSer.getbook(bookId);
		}catch(BookNotFoundException bex) {
			
		}
		return b;
//		if(b==null) {
//			throw new BookNotFoundException("Book not found");
//		}else {
//			return b;
//		}	
	}

}
