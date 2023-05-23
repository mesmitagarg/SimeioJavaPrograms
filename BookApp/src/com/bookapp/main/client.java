package com.bookapp.main;

import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

public class client {

	public static void main(String[] args) {
		IBookService bookservice = new BookServiceImpl();
		Book[] books = bookservice.getAll();
		for (Book book : books) {
			System.out.println(book);
		}
		Book[] books1 = bookservice.getByAuthor("Ram");
		for (Book book : books1) {
			System.out.println(book);
		}
		Book[] books2 = bookservice.getById(234);
		for (Book book : books2) {
			System.out.println(book);
		}
		
		

	}

}
