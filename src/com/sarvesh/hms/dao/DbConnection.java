package com.sarvesh.hms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sarvesh.hms.dto.Patient;

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

		

		} catch (Exception e) {
			e.printStackTrace();
		}

		return patient;

	}

}
