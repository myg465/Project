package com.javalec.ex.BCommand.MainCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.BDao.BDao;
import com.javalec.ex.BDto.BDto;
import com.javalec.ex.PDao.PDao;
import com.javalec.ex.PDto.PDto;

public class MainViewcommand implements MainCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		PDao pdao=new PDao();
		BDao bdao=new BDao();
		ArrayList<PDto> list = pdao.main_menu_view();
		ArrayList<BDto> blist = bdao.list(1, 5);
		String main_banner = pdao.bannerget();
		
		request.setAttribute("notice_list", blist);
		request.setAttribute("page", 1);
		request.setAttribute("main_menu", list);
		request.setAttribute("main_banner", main_banner);
		
	}

}
