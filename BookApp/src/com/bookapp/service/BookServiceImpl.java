package com.bookapp.service;

import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

public class BookServiceImpl implements IBookService {

	@Override
	public Book[] getAll() {
		
		return BookDetails.showBooks();
	}

	@Override
	public Book[] getByAuthor(String author) {
		Book[] books = BookDetails.showBooks();
		Book[] books1 = new Book[3];
		for (Book book: books) {			
			int i = 0;
			if (book.getAuthor().equals(author))
			{				
						books1[i] =book;
						i=i+1;
			}
		}		
		return books1;
	}

	@Override
	public Book[] getById(int bookId) {
		Book[] books = BookDetails.showBooks();
		Book[] books1 = new Book[3];
		for (Book book: books) {			
			int i = 0;
			if (book.getAuthor().equals(bookId))
			{				
						books1[i] =book;
						i=i+1;
			}
		}		
		return books1;
	}

	@Override
	public Book[] getByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

}
