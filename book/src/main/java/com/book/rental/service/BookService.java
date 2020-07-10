package com.book.rental.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BookService {



	void bookList(Model model);

	void bookWrite(MultipartHttpServletRequest request, Model model);

	String bookDelete(HashMap<String, String> reqMap, HttpServletRequest request);

	void bookModifyView(String bookId, Model model);

	void bookModify(MultipartHttpServletRequest request, Model model);


}
