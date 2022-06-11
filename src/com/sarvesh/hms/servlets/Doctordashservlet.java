package com.sarvesh.hms.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sarvesh.hms.dao.DbConnection;
import com.sarvesh.hms.dto.AppointmentDetails;
import com.sarvesh.hms.dto.Doctor;
import com.sarvesh.hms.dto.Patient;

/**
 * Servlet implementation class Doctordashservlet
 */
@WebServlet("/Doctordashservlet")
public class Doctordashservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Doctordashservlet() {
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
		
		

		String id = (String) request.getAttribute("id");
		DbConnection db = new DbConnection();
		Doctor doc = db.getDoctorDetails(id);
		ArrayList<AppointmentDetails> details = db.getAllAppointment(id,"DR");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/doctordash.jsp");
		request.setAttribute("doctor", doc);
		request.setAttribute("details", details);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
