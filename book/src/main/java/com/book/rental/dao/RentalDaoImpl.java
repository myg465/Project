package com.book.rental.dao;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class RentalDaoImpl implements RentalDao{
	
	@Inject
	SqlSession sqlSession;

	@Override
	public void rentalList(Model model) {

		model.addAttribute("rentalList",sqlSession.selectList("RentalDao.rentalList"));
		
	}

	@Override
	public String returnReg(String rentalId) {
		
		String result="";
		if(sqlSession.update("RentalDao,returnReg",rentalId)==1) {
			result="yes";
		}
		else {
			result="no";
		}
		return result;
	}

	
	

}
