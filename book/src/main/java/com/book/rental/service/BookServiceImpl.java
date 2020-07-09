package com.book.rental.service;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.book.rental.dao.BookDao;
import com.book.rental.dao.LoginDao;

@Service
public class BookServiceImpl implements BookService{

	@Inject
	BookDao bookDao;
//	@Resource(name="uploadPath")
//	String uploadPath;

	@Override
	public void bookList(Model model) {
		bookDao.bookList(model);
		
	}

	
	
	
	
	
}
