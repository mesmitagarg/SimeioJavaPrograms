package com.bookapp.util;

import com.bookapp.model.Book;

public class BookDetails {
	public static Book[] showBooks() {
	Book[] books = new Book[5];
	books[0] = new Book("Ramayan","Ram",234,"myth");
	books[1] = new Book("Ramayan1","Ram1",235,"tech");
	books[2] = new Book("Ramayan2","Ram2",236,"Fiction");
	books[3] = new Book("Ramayan3","Ram3",237,"Selfhelp");
	books[4] = new Book("Ramayan4","Ram4",238,"myth");
	return books;
}
}
