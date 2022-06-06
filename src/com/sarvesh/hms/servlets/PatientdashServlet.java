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
 * Servlet implementation class Patientdash
 */
@WebServlet("/Patientdash")
public class PatientdashServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientdashServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id  = (String) request.getAttribute("id");
		
		DbConnection db = new DbConnection();
		Patient patient  =  db.getPatientDetails(id);
	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/patientdash.jsp");
		request.setAttribute("patient", patient);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
