package com.book.rental.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;

public interface BookDao {

	void bookList(Model model);

	void bookWrite(Map<String, String> writeMap, Model model);

	String bookDelete(String bookId);

	String deletefile(String bookId);

	void bookModifyView(String bookId, Model model);

	void bookModify(Map<String, String> modifyMap, Model model);

}
