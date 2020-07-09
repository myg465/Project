package com.book.rental.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

public interface LoginService {

	String loginOk(HashMap<String, String> reqMap, HttpSession session);

}
