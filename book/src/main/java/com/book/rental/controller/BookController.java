package com.book.rental.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.book.rental.service.BookService;

@Controller
public class BookController {
	
	@Inject
	BookService bookService;
	
	@RequestMapping("bookWrite")
	public String bookWriteView() {
		return "bookWriteView";
	}
	
	@RequestMapping("bookWriteOk")
	public String bookWriteOk(MultipartHttpServletRequest request, Model model) {
		
		bookService.bookWrite(request,model);
		return "bookWriteView";
	}
	
	@RequestMapping("bookModify")
	public String bookModify(@RequestParam("bookId") String bookId, Model model) {
		
		bookService.bookModifyView(bookId,model);
		
		return "bookModifyView";
	}
	
	@RequestMapping("bookModifyOk")
	public String bookModifyOk(MultipartHttpServletRequest request, Model model) {
		
		bookService.bookModify(request,model);
		
		return "bookModifyView";
	}
	
	@ResponseBody
	@PostMapping("bookDelete")
	public HashMap<String, String> bookDelete(@RequestBody HashMap<String, String> reqMap, HttpServletRequest request) {
		
		HashMap<String, String> resMap=new HashMap<String, String>();
		resMap.put("result", bookService.bookDelete(reqMap,request));
		
		return resMap;
	}
	
	
	

}
