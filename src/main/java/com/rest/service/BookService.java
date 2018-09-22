package com.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.controller.BookController;
import com.rest.exception.BookNotFoundException;
import com.rest.model.Book;

@Service
public class BookService {
	private static List<Book> bookList = new ArrayList<>();
	private static final Logger LOGGER =LoggerFactory.getLogger(BookController.class);
	private static final String CLASSNAME = "BookService";
	
//	static {
//		bookList.add(new Book(1,"abc",10));
//		bookList.add(new Book(2,"pqr",20));
//		bookList.add(new Book(3,"qwr",30));
//		bookList.add(new Book(4,"tyu",40));
//	}
	public List<Book> getAllbooks() {
		LOGGER.info("Inside Controller::"+ CLASSNAME + " Method:: getAllbooks()" );
		List<Book> resultList = new ArrayList<>();
		for(Book book:bookList) {
			resultList.add(book);
		}
		return resultList;
	}
	public Book getbook(int id) throws BookNotFoundException {
		LOGGER.info("Inside Controller::"+ CLASSNAME + " Method:: getbook()" );
		for(Book book:bookList) {
			if(book.getBookId() == id) {
				return book;
			}
		}
		return null;
		 //throw new BookNotFoundException("Book not found for id-"+id);
		
	}

}
