package com.book.rental.controller;

import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.rental.service.LoginService;

@Controller
public class LoginController {

	@Inject
	LoginService loginService;
	
	@RequestMapping("login")
	public String adminLoginView() {
		return "loginForm";
	}
	
	@ResponseBody
	@RequestMapping(value = "loginOk", method = RequestMethod.POST)
	public HashMap<String, String> loginOk(@RequestBody HashMap<String, String> reqMap, HttpSession session) throws Exception{
		
		HashMap<String, String> resMap=new HashMap<String, String>();
		resMap.put("result", loginService.loginOk(reqMap,session));
		System.out.println(resMap.get("result"));
		
		return resMap;
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:login";
	}
}
