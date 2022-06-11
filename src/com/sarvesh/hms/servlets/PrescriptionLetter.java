package com.sarvesh.hms.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sarvesh.hms.dao.DbConnection;
import com.sarvesh.hms.dto.PrescriptionDetails;
import sun.launcher.resources.launcher;

/**
 * Servlet implementation class PrescriptionLetter
 */
@WebServlet("/PrescriptionLetter")
public class PrescriptionLetter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrescriptionLetter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String diag = request.getParameter("diag");

		DbConnection connection = new DbConnection();
		PrescriptionDetails letter = connection.getPrscription(diag);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/prescriptionletter.jsp");
		request.setAttribute("details", letter);

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
