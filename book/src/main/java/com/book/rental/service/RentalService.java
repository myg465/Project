package com.book.rental.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface RentalService {

	void rentalList(Model model);

	String returnReg(HashMap<String, String> reqMap);

}
