package com.book.rental.service;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.book.rental.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService{

	@Inject
	LoginDao loginDao;
//	@Resource(name="uploadPath")
//	String uploadPath;

	@Override
	public String loginOk(HashMap<String, String> reqMap, HttpSession session) {
		
		String result="";
		String name=loginDao.loginOk(reqMap);
		if(name!=null) {
			session.setAttribute("authId", reqMap.get("id"));
			session.setAttribute("name", name);
			result="yes";
		}
		else {
			result="no";
		}
		
		
		return result;
	}
	
	
	
	
}
