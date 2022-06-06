package com.sarvesh.hms.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sarvesh.hms.dao.DbConnection;
import com.sarvesh.hms.dto.Patient;

/**
 * Servlet implementation class signinservlet
 */
@WebServlet("/SigninServlet")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SigninServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/index.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("username");
		String pass = request.getParameter("password");

		Patient patient = new Patient();

		if (uname != null && !uname.isEmpty()) {
			patient.setUserName(uname);
		}

		if (pass != null && !pass.isEmpty()) {
			patient.setPassword(pass);
		}

		DbConnection connection = new DbConnection();
		String result = connection.login(patient);

		if (!result.equals("-1")) {
			PatientdashServlet servlet = new PatientdashServlet();
			request.setAttribute("id", result);

			servlet.doGet(request, response);
		} else {
			request.setAttribute("result", result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/index.jsp");
			dispatcher.forward(request, response);
		}

	}

}
