package com.bookapp.main;

import java.util.Arrays;
import java.util.stream.Stream;

import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

public class client {

	public static void main(String[] args) {
		IBookService bookservice = new BookServiceImpl();
		System.out.println("All book Details");
		bookservice.getAll().forEach(book-> System.out.println(book));
		System.out.println("book Details by author Ram1");
		bookservice.getByAuthor("Ram1").forEach(book-> System.out.println(book));
		System.out.println("book Details by id 234");
		System.out.println(bookservice.getById(234));
		System.out.println("book Details by category myth");
		bookservice.getByCategory("myth").forEach(book-> System.out.println(book));
		
		
		
	}

}
