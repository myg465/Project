package com.book.rental.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.book.rental.service.BookService;
import com.book.rental.service.RentalService;

@Controller
public class MainController {
	
	@Inject
	BookService bookService;
	
	@Inject
	RentalService rentalService;
	
	@RequestMapping("main")
	public String mainView() {
		return "main";
	}
	
	@RequestMapping("bookList")
	public String bookList(Model model) {
		
		bookService.bookList(model);
		return "bookList";
	}
	
	@RequestMapping("rentalList")
	public String rentalList(Model model) {
		
		rentalService.rentalList(model);
		return "rentalList";
	}
	
	
}
