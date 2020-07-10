package com.book.rental.dao;

import java.util.HashMap;
import java.util.Map;

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

	@Override
	public void bookWrite(Map<String, String> writeMap, Model model) {
		
		model.addAttribute("writeResult",sqlSession.insert("BookDao.bookWrite",writeMap));
		
	}

	@Override
	public String bookDelete(String bookId) {
		String result="";
		if(sqlSession.delete("BookDao.bookDelete",bookId)==1) {
			result="ok";
		}
		else {
			result="no";
		}
		return result;
	}
	
	@Override
	public void bookModifyView(String bookId, Model model) {
		
		model.addAttribute("modifyView",sqlSession.selectOne("BookDao.bookModifyView",bookId));
		
	}
	
	@Override
	public void bookModify(Map<String, String> modifyMap, Model model) {
		
		model.addAttribute("modifyResult",sqlSession.update("BookDao.bookModify",modifyMap));
		
	}

	@Override
	public String deletefile(String bookId) {
		
		return sqlSession.selectOne("BookDao.deletefile",bookId);
	}


	
	

}
