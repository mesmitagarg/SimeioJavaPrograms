package com.bookapp.util;

import java.util.Arrays;
import java.util.List;

import com.bookapp.model.Book;

public class BookDetails {
	public static List<Book> showBooks() {
	List<Book> books = Arrays.asList(
			new Book("Ramayan","Ram",234,"myth"),
			new Book("Ramayan1","Ram1",235,"tech"),
			 new Book("Ramayan2","Ram2",236,"Fiction"),
			 new Book("Ramayan3","Ram3",237,"Selfhelp"),
			 new Book("Ramayan4","Ram4",238,"myth")
			);
		
	return books;
}
}
