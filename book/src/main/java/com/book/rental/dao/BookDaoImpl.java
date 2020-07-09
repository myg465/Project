package com.book.rental.dao;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class BookDaoImpl implements BookDao{
	
	@Inject
	SqlSession sqlSession;

	@Override
	public void bookList(Model model) {
		
		model.addAttribute("bookList",sqlSession.selectList("BookDao.bookList"));
		
	}

	
	

}
