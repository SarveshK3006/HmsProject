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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/index.jsp");
//        dispatcher.forward(request, response);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/signup.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fname = request.getParameter("fname");
		String mname = request.getParameter("mname");
		String lname = request.getParameter("lname");
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String bg = request.getParameter("bg");
		String address = request.getParameter("address");
		String gender = request.getParameter("gen");
		String mob = request.getParameter("mob");
		String age = request.getParameter("age");
		Patient patient = new Patient();

		if (fname != null && !fname.isEmpty()) {
			patient.setFirstName(fname);
		}

		if (mname != null && !mname.isEmpty()) {
			patient.setMiddleName(mname);
		}

		if (lname != null && !lname.isEmpty()) {
			patient.setLastName(lname);
		}

		if (uname != null && !uname.isEmpty()) {
			patient.setUserName(uname);
		}

		if (pass != null && !pass.isEmpty()) {
			patient.setPassword(pass);
		}

		if (dob != null && !dob.isEmpty()) {
			patient.setDob(dob);
		}

		if (age != null && !age.isEmpty()) {
			patient.setAge(age);
		}

		if (email != null && !email.isEmpty()) {
			patient.setEmailId(email);
		}

		if (bg != null && !bg.isEmpty()) {
			patient.setBloodGroup(bg);
		}

		if (gender != null && !gender.isEmpty()) {
			patient.setGender(gender);
		}

		if (address != null && !address.isEmpty()) {
			patient.setAddress(address);
		}

		if (mob != null && !mob.isEmpty()) {
			patient.setPhoneNo(mob);
		}

		DbConnection connection = new DbConnection();
		connection.insertPatient(patient);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/signup.jsp");
		request.setAttribute("result", "done");
		dispatcher.forward(request, response);

	}

}
