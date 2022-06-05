package com.sarvesh.hms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sarvesh.hms.dto.Patient;

public class DbConnection {

	static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	static final String USER = "root";
	static final String PASS = "root";
	String SQL="Insert into patient "
			+ " (firstName,lastName,middleName,userName,password,address,emailId,gender,phoneNo,bloodGroup,age,dob) "
			+ " values(?,?,?,?,?,?,?,?,?,?,?,?) ";

	public void executeQuery(Patient patient) {

		try {
			
			// STEP 1:  Load Driver
			Class.forName("com.mysql.jdbc.Driver"); 
			
			// Step 2: Create Connection
			Connection conn=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/test","root","root"); 
			
			//Step 3: create Statement
			PreparedStatement stmt = conn.prepareStatement(SQL);
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
			//Step 4: Execute Query
			stmt.executeUpdate();
			
			//step 5: 
			conn.close();
			

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
