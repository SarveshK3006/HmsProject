package com.sarvesh.hms.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sarvesh.hms.dao.DbConnection;
import com.sarvesh.hms.dto.Appointment;
import com.sarvesh.hms.dto.AppointmentDetails;

/**
 * Servlet implementation class BookAppoint
 */
@WebServlet("/BookAppoint")
public class BookAppoint extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookAppoint() {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/patientdash.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String doctorId = request.getParameter("doc");
		String date = request.getParameter("datetime");
		String petientId = request.getParameter("petientId");

		String timeSlot = request.getParameter("timeslot");

		Appointment appointment = new Appointment();
		appointment.setPatientId(petientId);
		appointment.setDoctorId(doctorId);
		appointment.setTimeSlot(timeSlot);
		System.err.println(timeSlot);

		DateTimeFormatter formatter6 = DateTimeFormatter.ofPattern("yyy-MM-dd");
		LocalDate date2 = LocalDate.parse(date, formatter6);
		appointment.setAppDate(date2);

		System.err.println(appointment + "kjbckbwci");

		DbConnection connection = new DbConnection();

		int res = connection.bookAppointment(appointment);
	

		System.err.println(res);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/patientdash.jsp");
//		dispatcher.forward(request, response);

	}

}
