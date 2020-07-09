package com.book.rental.dto;

import java.sql.Timestamp;

public class RentalDto {

	public RentalDto() {}
	
	public RentalDto(int rentalId, String rentalName, String rentalPhone, Timestamp rentalDate, Timestamp returnExpDate,
			Timestamp returnDate, int rentalBook, String bookName, String filename) {
		super();
		this.rentalId = rentalId;
		this.rentalName = rentalName;
		this.rentalPhone = rentalPhone;
		this.rentalDate = rentalDate;
		this.returnExpDate = returnExpDate;
		this.returnDate = returnDate;
		this.rentalBook = rentalBook;
		this.bookName = bookName;
		this.filename = filename;
	}

	private int rentalId;
	private String rentalName;
	private String rentalPhone;
	private Timestamp rentalDate;
	private Timestamp returnExpDate;
	private Timestamp returnDate;
	private int rentalBook;
	private String bookName;
	private String filename;
	
	
	public int getRentalId() {
		return rentalId;
	}

	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}

	public String getRentalName() {
		return rentalName;
	}

	public void setRentalName(String rentalName) {
		this.rentalName = rentalName;
	}

	public String getRentalPhone() {
		return rentalPhone;
	}

	public void setRentalPhone(String rentalPhone) {
		this.rentalPhone = rentalPhone;
	}

	public Timestamp getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Timestamp rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Timestamp getReturnExpDate() {
		return returnExpDate;
	}

	public void setReturnExpDate(Timestamp returnExpDate) {
		this.returnExpDate = returnExpDate;
	}

	public Timestamp getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}

	public int getRentalBook() {
		return rentalBook;
	}

	public void setRentalBook(int rentalBook) {
		this.rentalBook = rentalBook;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	
}
