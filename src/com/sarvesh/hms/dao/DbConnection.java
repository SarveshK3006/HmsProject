package com.sarvesh.hms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sarvesh.hms.dto.Appointment;
import com.sarvesh.hms.dto.AppointmentDetails;
import com.sarvesh.hms.dto.Doctor;
import com.sarvesh.hms.dto.Patient;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

public class DbConnection {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	private static final String USER = "root";
	private static final String PASS = "root";
	private Connection conn = null;
	private final String SQL_INSERT_PATIENT = "Insert into patient "
			+ " (firstName,lastName,middleName,userName,password,address,emailId,gender,phoneNo,bloodGroup,age,dob) "
			+ " values(?,?,?,?,?,?,?,?,?,?,?,?) ";

	private final String SQL_CHECK_LOGIN = " SELECT id FROM PATIENT WHERE userName = ? and password = ? ";

	private final String SQL_GET_PATIENT = " SELECT * FROM PATIENT WHERE id = ? ";

	private final String SQL_BOOK_APPOINT = " INSERT INTO APPOINTMENT (patientId , doctorId,appDate , timeslot )  VALUES (?,? , ?,? ) ";

	private final String SQL_GETALL_DOCTOR = "SELECT * FROM DOCTOR ";

	private final String SQL_PATIENT_DASH = " SELECT ap.id , p.id AS patientId,CONCAT(p.firstName,\" \",p.lastName) AS patientName , "
			+ " dc.id AS doctorId,CONCAT(dc.firstName ,\" \",dc.lastName )AS doctorName, ap.appDate,ap.timeslot "
			+ " FROM appointment ap JOIN doctor dc ON ap.doctorId=dc.id JOIN patient p ON ap.patientId=p.id where p.id = ? ";

	public DbConnection() {
		try {
			// STEP 1: Load Driver
			Class.forName("com.mysql.jdbc.Driver");

			// Step 2: Create Connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void insertPatient(Patient patient) {

		try {

			// Step 3: create Statement
			PreparedStatement stmt = conn.prepareStatement(SQL_INSERT_PATIENT);
			stmt.setString(1, patient.getFirstName());
			stmt.setString(2, patient.getLastName());
			stmt.setString(3, patient.getMiddleName());
			stmt.setString(4, patient.getUserName());
			stmt.setString(5, patient.getPassword());
			stmt.setString(6, patient.getAddress());
			stmt.setString(7, patient.getEmailId());
			stmt.setString(8, patient.getGender());
			stmt.setString(9, patient.getPhoneNo());
			stmt.setString(10, patient.getBloodGroup());
			stmt.setString(11, patient.getAge());
			stmt.setString(12, patient.getDob());
			// Step 4: Execute Query
			stmt.executeUpdate();

			// step 5:
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String login(Patient patient) {
		String temp = "-1";
		try {
			PreparedStatement stmt = conn.prepareStatement(SQL_CHECK_LOGIN);

			stmt.setString(1, patient.getUserName());
			stmt.setString(2, patient.getPassword());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				long id = rs.getLong(1);
				;

				temp = id + "";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return temp;

	}

	// start

	public Patient getPatientDetails(String id) {
		Patient patient = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(SQL_GET_PATIENT);
			stmt.setString(1, id);

			ResultSet rs = stmt.executeQuery();
			patient = new Patient();
			while (rs.next()) {

				patient.setId(rs.getLong(1));
				patient.setFirstName(rs.getString(4));
				patient.setMiddleName(rs.getString(5));
				patient.setLastName(rs.getString(6));
				patient.setAddress(rs.getString(12));
				patient.setDob(rs.getString(13));
				patient.setBloodGroup(rs.getString("bloodGroup"));
				patient.setPhoneNo(rs.getString("phoneNo"));
				patient.setEmailId(rs.getString("emailId"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return patient;

	}

	public int bookAppointment(Appointment appointment) {
		int temp = -1;
		;
		try {

			PreparedStatement stmt = conn.prepareStatement(SQL_BOOK_APPOINT);
			stmt.setString(1, appointment.getPatientId());
			stmt.setString(2, appointment.getDoctorId());
			stmt.setDate(3, Date.valueOf(appointment.getAppDate()));
			stmt.setString(4, appointment.getTimeSlot());
			temp = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;

	}

	public ArrayList<Doctor> getDoctorList() {
		// TODO Auto-generated method stub
		ArrayList<Doctor> list = null;
		try {

			PreparedStatement stmt = conn.prepareStatement(SQL_GETALL_DOCTOR);
			ResultSet rs = stmt.executeQuery();
			list = new ArrayList<Doctor>();
			while (rs.next()) {

				Doctor dc = new Doctor();
				dc.setId(rs.getInt(1));
				dc.setFirstName(rs.getString(4));
				dc.setLastName(rs.getString(5));
				dc.setEmailId(rs.getString(6));
				dc.setPhoneNo(rs.getString(7));
				dc.setAddress(rs.getString(8));
				dc.setBloodGroup(rs.getString(9));
				dc.setGender(rs.getString(10));
				dc.setDegree(rs.getString(11));
				dc.setSpecialization(rs.getNString(12));

				list.add(dc);

			}
			System.out.println(list);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<AppointmentDetails> getAllAppointment(String patientId) {

		ArrayList<AppointmentDetails> list = null;

		try {

			PreparedStatement stmt = conn.prepareStatement(SQL_PATIENT_DASH);
			stmt.setString(1, patientId);
			ResultSet rs = stmt.executeQuery();
			list = new ArrayList<AppointmentDetails>();

			while (rs.next()) {

				AppointmentDetails ad = new AppointmentDetails();

				ad.setId(rs.getLong("id") + "");
				ad.setDoctorId(rs.getLong("doctorId") + "");
				ad.setDoctorName(rs.getString("doctorName"));
				ad.setPatientId(rs.getLong("patientId") + "");
				ad.setPatientName(rs.getString("patientName"));
				ad.setTimeSlot(rs.getString("timeslot"));
				System.out.println(rs.getDate("appDate"));
				ad.setDate(rs.getDate("appDate") + "");
				list.add(ad);

			}

			while (rs.next()) {

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return list;
	}

}
