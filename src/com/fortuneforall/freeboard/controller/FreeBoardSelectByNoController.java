package com.fortuneforall.freeboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.comment.dao.CommentDAO;
import com.fortuneforall.comment.domain.Comment;
import com.fortuneforall.drink.dao.DrinkDAO;
import com.fortuneforall.freeboard.dao.FreeBoardDAO;

@WebServlet("/com.fortuneforall.freeboard.controller/FreeBoardSelectByNoController")
public class FreeBoardSelectByNoController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeBoardDAO dao = new FreeBoardDAO();
		int no = Integer.parseInt(request.getParameter("no"));
		String id = request.getParameter("id");
		int result = dao.checkId(id, no);
		request.setAttribute("result", result);
		
		request.setAttribute("board", dao.selectByNo(no));
		request.setAttribute("id", id);
		
		CommentDAO cDAO = new CommentDAO();
		List<Comment> list = cDAO.selectBoard(no);
		request.setAttribute("comment", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/FreeBoard/board.jsp");
		rd.forward(request, response);
	}
}
