package com.fortuneforall.drink.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fortuneforall.drink.dao.DrinkDAO;
import com.fortuneforall.drink.domain.Drink;
import com.fortuneforall.member.domain.Member;
import com.fortuneforall.util.MlecFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;


@WebServlet("/com.fortuneforall.drink.controller/drinkinsertcontroller")
public class DrinkInsertController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("id");

		HttpSession session = request.getSession();			
		Member m = (Member)session.getAttribute("member");
		
		Drink d = new Drink();
		d.setTitle(title);
		d.setWriter(id);
		d.setContent(content);
		
//		String upload = "C:\\java97\\server-work\\wtpwebapps\\05_servletjsp\\upload";
//		String path = new SimpleDateFormat("/yyyy/MM/dd/HH").format(new Date());
//		File f = new File(upload+path);
//		if(f.exists() == false) f.mkdirs();
//		MultipartRequest mRequest = new MultipartRequest(request, upload+path,1024*1024*30,"utf-8",new MlecFileRenamePolicy());
		
		DrinkDAO dao = new DrinkDAO();
		dao.insertDrink(d);
		
		response.sendRedirect("/FortuneForAll/com.fortuneforall.drink.controller/DrinkSelectController?page=1&id="+id);
	}
}