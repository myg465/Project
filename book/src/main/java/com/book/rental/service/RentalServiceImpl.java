package com.book.rental.service;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.book.rental.dao.LoginDao;
import com.book.rental.dao.RentalDao;

@Service
public class RentalServiceImpl implements RentalService{

	@Inject
	RentalDao rentalDao;
//	@Resource(name="uploadPath")
//	String uploadPath;

	@Override
	public void rentalList(Model model) {
		
		rentalDao.rentalList(model);
		
	}

	@Override
	public String returnReg(HashMap<String, String> reqMap) {
		
		String rentalId=reqMap.get("rentalId");
		return rentalDao.returnReg(rentalId);
	}

	
	
	
	
	
}
