package com.sarvesh.hms.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupServlet
 */
//@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/index.jsp");
        dispatcher.forward(request, response);
        

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	String  user =	request.getParameter("username");
	String  pass = 	request.getParameter("password");
	
	if(pass.equalsIgnoreCase("Sarvesh@123")) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/NewFile.jsp");
        dispatcher.forward(request, response);
	}else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
        dispatcher.forward(request, response);
	}
		
	}

}
