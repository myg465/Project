package com.book.rental.controller;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.rental.service.RentalService;

@Controller
public class RentalController {

	@Inject
	RentalService rentalService;
	
	@ResponseBody
	@PostMapping("returnReg")
	public HashMap<String, String> returnReg(HashMap<String, String> reqMap){
		
		HashMap<String, String> resMap = new HashMap<String, String>(); 
		resMap.put("result",rentalService.returnReg(reqMap));
		
		return resMap;
	}
	
	
}
