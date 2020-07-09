package com.book.rental.dto;

import java.sql.Timestamp;

public class BookDto {

	public BookDto() {}
	

	public BookDto(int bookId, String bookName, String bookDesc, String author, String filename, Timestamp regDate,
			String category) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookDesc = bookDesc;
		this.author = author;
		this.filename = filename;
		this.regDate = regDate;
		this.category = category;
	}


	private int bookId;
	private String bookName;
	private String bookDesc;
	private String author;
	private String filename;
	private Timestamp regDate;
	private String category;
	
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookDesc() {
		return bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	
	
	
	
}
