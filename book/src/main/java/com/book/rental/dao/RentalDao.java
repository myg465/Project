package com.book.rental.dao;

import java.util.HashMap;

import org.springframework.ui.Model;

public interface RentalDao {

	void rentalList(Model model);

	String returnReg(String rentalId);

}
