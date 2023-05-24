package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

public class BookServiceImpl implements IBookService {

	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return BookDetails.showBooks();
	}

	@Override
	public List<Book> getByAuthor(String author) {
		List<Book> books = BookDetails.showBooks();
		
		List<Book> booksByAuthor = books.stream()
				.filter(book-> book.getAuthor().equals(author)).collect(Collectors.toList());
				
		return booksByAuthor;
	}

	@Override
	public Optional<Book> getById(int bookId) {
		List<Book> books = BookDetails.showBooks();
		return books.stream()
		.filter(book-> (book.getBookId()==bookId)).findFirst();
		
	}

	@Override
	public List<Book> getByCategory(String category) {
			List<Book> books = BookDetails.showBooks();
		
		return books.stream()
				.filter(book-> book.getCategory().equals(category)).collect(Collectors.toList());
		
	}

	
}
