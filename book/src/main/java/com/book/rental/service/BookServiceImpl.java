package com.book.rental.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.book.rental.dao.BookDao;
import com.book.rental.dao.LoginDao;

@Service
public class BookServiceImpl implements BookService{

	@Inject
	BookDao bookDao;
//	@Resource(name="uploadPath")
//	String uploadPath;

	@Override
	public void bookList(Model model) {
		bookDao.bookList(model);
		
	}

	@Override
	public void bookWrite(MultipartHttpServletRequest request, Model model) {
		
		String path = request.getSession().getServletContext().getRealPath("/files");
		Map<String, String> writeMap= new HashMap<String, String>();
		
		writeMap.put("bookName", request.getParameter("bookName"));
		writeMap.put("author", request.getParameter("author"));
		writeMap.put("category", request.getParameter("category"));
		writeMap.put("bookDesc", request.getParameter("bookDesc"));
		
		MultipartFile file=request.getFile("filename");
		UUID uuid=UUID.randomUUID();
		String orifile=uuid.toString()+file.getOriginalFilename();
		writeMap.put("filename",orifile);
		String filepath=path+"\\"+orifile;
		System.out.println(filepath);
		try {
			file.transferTo(new File(filepath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bookDao.bookWrite(writeMap,model);
		
		
	}
	
	@Override
	public void bookModifyView(String bookId, Model model) {
		
		bookDao.bookModifyView(bookId,model);
		
	}
	
	@Override
	public void bookModify(MultipartHttpServletRequest request, Model model) {

		String path = request.getSession().getServletContext().getRealPath("/files");
		Map<String, String> modifyMap= new HashMap<String, String>();
		
		modifyMap.put("bookId",request.getParameter("bookId"));
		modifyMap.put("bookName", request.getParameter("bookName"));
		modifyMap.put("author", request.getParameter("author"));
		modifyMap.put("category", request.getParameter("category"));
		modifyMap.put("bookDesc", request.getParameter("bookDesc"));
		String orifile=request.getParameter("orifile");
		MultipartFile file=request.getFile("filename");
		if(file==null || file.getOriginalFilename().equals("")) {
			modifyMap.put("filename", orifile);
			bookDao.bookModify(modifyMap, model);
			return;
		}
		else {
			File f=new File(path+"\\"+orifile);
			f.delete();
			UUID uuid=UUID.randomUUID();
			String newfile=uuid.toString()+file.getOriginalFilename();
			modifyMap.put("filename",newfile);
			String filepath=path+"\\"+newfile;
			try {
				file.transferTo(new File(filepath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		bookDao.bookModify(modifyMap,model);
		
	}
	

	@Override
	public String bookDelete(HashMap<String, String> reqMap, HttpServletRequest request) {
		
		String path = request.getSession().getServletContext().getRealPath("/files");
		String bookId=reqMap.get("bookId");
		String filename=bookDao.deletefile(bookId);
		String filepath=path+"\\"+filename;
		File f=new File(filepath);
		f.delete();
		
		return bookDao.bookDelete(bookId);
	}



	
	
	
	
	
}
