package com.sarvesh.hms.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sarvesh.hms.dao.DbConnection;
import com.sarvesh.hms.dto.Prescription;
import com.sarvesh.hms.dto.Tests;

/**
 * Servlet implementation class PrescriptionServlet
 */
@WebServlet("/PrescriptionServlet")
public class PrescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrescriptionServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String prescription = request.getParameter("pre");
		String rectests = request.getParameter("test");
		String doctorid = request.getParameter("doctorid");
		String patientid = request.getParameter("patientid");
		String remark = request.getParameter("remark");
		String appoId = request.getParameter("appoId");

		String[] temp1 = prescription.split("@");
		

		List<Prescription> list1 = new ArrayList<>();
		for (int i = 1; i < temp1.length; i++) {
			Prescription pres = new Prescription();
			pres.setPatientId(patientid);
			pres.setDoctorId(doctorid);
			pres.setDrugs(temp1[i]);
			list1.add(pres);
		}

		List<Tests> list = new ArrayList<>();
		String[] temp2 = rectests.split("@");
		for (int i = 1; i < temp2.length; i++) {
			Tests tests = new Tests();
			tests.setPatientId(patientid);
			tests.setDoctorId(doctorid);
			tests.setTests(temp2[i]);
			list.add(tests);
		}
		
		DbConnection connection =  new DbConnection();
		connection.setDiagnosis(list1,list,doctorid,patientid,appoId,remark);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/diagnosis.jsp");
		request.setAttribute("result", "done");

	}

}
