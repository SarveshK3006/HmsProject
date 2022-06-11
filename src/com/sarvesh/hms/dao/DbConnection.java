package com.sarvesh.hms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.sarvesh.hms.dto.Appointment;
import com.sarvesh.hms.dto.AppointmentDetails;
import com.sarvesh.hms.dto.Doctor;
import com.sarvesh.hms.dto.Patient;
import com.sarvesh.hms.dto.Prescription;
import com.sarvesh.hms.dto.PrescriptionDetails;
import com.sarvesh.hms.dto.Tests;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

public class DbConnection {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	private static final String USER = "root";
	private static final String PASS = "root";
	private static final String SQL_UPDATE_APPOINTMENT = "UPDATE appointment SET isDiagnosed =  ? , diagnosisId = ? where id = ?";
	private Connection conn = null;
	private final String SQL_INSERT_PATIENT = "Insert into patient "
			+ " (firstName,lastName,middleName,userName,password,address,emailId,gender,phoneNo,bloodGroup,age,dob) "
			+ " values(?,?,?,?,?,?,?,?,?,?,?,?) ";

	private final String SQL_CHECK_LOGIN = " SELECT id FROM PATIENT WHERE userName = ? and password = ? ";

	private final String SQL_GET_PATIENT = " SELECT * FROM PATIENT WHERE id = ? ";

	private final String SQL_BOOK_APPOINT = " INSERT INTO APPOINTMENT (patientId , doctorId,appDate , timeslot )  VALUES (?,? , ?,? ) ";

	private final String SQL_GETALL_DOCTOR = "SELECT * FROM DOCTOR ";

	private String SQL_PATIENT_DR_DASH = " SELECT ap.id ,ap.isDiagnosed , ap.diagnosisId ,p.id AS patientId,CONCAT(p.firstName,\" \",p.lastName) AS patientName , "
			+ " dc.id AS doctorId,CONCAT(dc.firstName ,\" \",dc.lastName )AS doctorName, ap.appDate,ap.timeslot "
			+ " FROM appointment ap JOIN doctor dc ON ap.doctorId=dc.id JOIN patient p ON ap.patientId=p.id ";

	private final String SQL_GET_DOCTOR = " SELECT * FROM DOCTOR WHERE id = ? ";

	private final String SQL_CHECK_LOGIN_DR = " SELECT id FROM DOCTOR WHERE userName = ? and password = ? ";

	private final String SQL_ADD_DIAGNOSIS = " INSERT INTO diagnosis (appoId,patientId,doctorId,remark) VALUES (?,?,?,?) ";

	private final String SQL_SELECT_DIAGNOSIS = " Select * from diagnosis where  appoId = ? ";

	private final String SQL_ADD_TESTS = " INSERT INTO tests (diagnosisid,tests,doctorid,patientid) VALUES (?,?,?,?) ";

	private final String SQL_ADD_PRESCRIPTION = " INSERT INTO prescription (patientid,doctorid,drugs,diagnosisid) VALUES (?,?,?,?) ";

	private final String SQ_GET_PRESCRIPTION = " SELECT d.id ,dr.degree ,CONCAT(p.firstName,\" \",p.lastName) AS 'patientName' , CONCAT(dr.firstName,\" \",dr.lastName) AS 'doctorName' FROM diagnosis d JOIN patient p ON d.patientId=p.id JOIN doctor dr on d.doctorId=dr.id WHERE d.id = ? ";

	private final String SQ_GET_TEST = " SELECT * FROM tests t WHERE t.diagnosisid = ? ";
	private final String SQ_GET_prescription = " SELECT * FROM prescription t WHERE t.diagnosisid = ? ";

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

	public String ifIsDoctorAndLogin(Doctor doctor) {
		String temp = "-1";
		try {
			PreparedStatement stmt = conn.prepareStatement(SQL_CHECK_LOGIN_DR);

			stmt.setString(1, doctor.getUserName());
			stmt.setString(2, doctor.getPassword());

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

	public ArrayList<AppointmentDetails> getAllAppointment(String patientId, String flag) {

		ArrayList<AppointmentDetails> list = null;

		try {

			if (flag.equalsIgnoreCase("PA")) {
				SQL_PATIENT_DR_DASH = SQL_PATIENT_DR_DASH + " where  p.id = ? ";
			} else {
				SQL_PATIENT_DR_DASH = SQL_PATIENT_DR_DASH
						+ " where  (ap.isDiagnosed != 'true'  OR  ap.isDiagnosed IS  NULL) and dc.id = ? ";
			}

			PreparedStatement stmt = conn.prepareStatement(SQL_PATIENT_DR_DASH);
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
				ad.setDate(rs.getDate("appDate") + "");
				if (flag.equalsIgnoreCase("PA") && (rs.getString("isDiagnosed") != null
						|| rs.getString("isDiagnosed").equalsIgnoreCase("TRUE"))) {

					ad.setDiagnosis(rs.getString("diagnosisId"));
				}
				list.add(ad);

			}

			while (rs.next()) {

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return list;
	}

	public Doctor getDoctorDetails(String id) {
		Doctor doc = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(SQL_GET_DOCTOR);
			stmt.setString(1, id);

			ResultSet rs = stmt.executeQuery();
			doc = new Doctor();
			while (rs.next()) {

				doc.setId(rs.getLong(1));
				doc.setFirstName(rs.getString("firstName"));
				doc.setLastName(rs.getString("lastName"));
				doc.setAddress(rs.getString("address"));
				doc.setBloodGroup(rs.getString("bloodGroup"));
				doc.setPhoneNo(rs.getString("phoneNo"));
				doc.setEmailId(rs.getString("emailId"));
				doc.setDegree(rs.getString("degree"));
				doc.setGender(rs.getString("gender"));
				doc.setSpecialization(rs.getString("speciality"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return doc;

	}

	public void setDiagnosis(List<Prescription> prescriptions, List<Tests> tests, String doctorid, String patientid,
			String appoId, String remark) {
		PreparedStatement pstmt = null;
		AtomicLong atomicLong = new AtomicLong();
		try {
			pstmt = conn.prepareStatement(SQL_ADD_DIAGNOSIS);
			pstmt.setString(1, appoId);
			pstmt.setString(2, patientid);
			pstmt.setString(3, doctorid);
			pstmt.setString(4, remark);
			int temp = pstmt.executeUpdate();

			pstmt.close();
			pstmt = conn.prepareStatement(SQL_SELECT_DIAGNOSIS);
			pstmt.setString(1, appoId);
			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {

				atomicLong.set(resultSet.getLong("id"));
			}

			prescriptions.stream().forEach(e -> e.setDiagnosisId(atomicLong.get() + ""));
			tests.stream().forEach(e -> e.setDiagnosisId(atomicLong.get() + ""));
			setPrescription(prescriptions);
			setTests(tests);

			updateAppointment(appoId, atomicLong.get());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void updateAppointment(String appoId, long diagId) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(SQL_UPDATE_APPOINTMENT);
			stmt.setString(1, "true");
			stmt.setLong(2, diagId);
			stmt.setString(3, appoId);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setPrescription(List<Prescription> prescriptions) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(SQL_ADD_PRESCRIPTION);

			for (Prescription prep : prescriptions) {

				pstmt.setString(1, prep.getPatientId());
				pstmt.setString(2, prep.getDoctorId());
				pstmt.setString(3, prep.getDrugs());
				pstmt.setString(4, prep.getDiagnosisId());
				pstmt.executeUpdate();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void setTests(List<Tests> tests) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(SQL_ADD_TESTS);

			for (Tests prep : tests) {

				pstmt.setString(1, prep.getDiagnosisId());
				pstmt.setString(2, prep.getTests());
				pstmt.setString(3, prep.getDoctorId());
				pstmt.setString(4, prep.getPatientId());

				pstmt.executeUpdate();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public PrescriptionDetails getPrscription(String diag) {
		PreparedStatement stmt = null;
		PrescriptionDetails details = null;
		try {
			stmt = conn.prepareStatement(SQ_GET_PRESCRIPTION);
			stmt.setString(1, diag);

			ResultSet rs = stmt.executeQuery();
			details = new PrescriptionDetails();

			while (rs.next()) {
				details.setDiagnosisId(rs.getString("id"));
				details.setDocrotName(rs.getString("doctorName"));
				details.setPatientName(rs.getString("patientName"));
				details.setDocDegree(rs.getString("degree"));

			}

			stmt.close();
			stmt = conn.prepareStatement(SQ_GET_TEST);
			stmt.setString(1, details.getDiagnosisId());
			ResultSet resultSet = stmt.executeQuery();
			List<Tests> list = new ArrayList<>();
			while (resultSet.next()) {
				Tests tests = new Tests();
				tests.setTests(resultSet.getString("tests"));
				list.add(tests);

			}
			stmt.close();

			stmt = conn.prepareStatement(SQ_GET_prescription);
			stmt.setString(1, details.getDiagnosisId());
			ResultSet res = stmt.executeQuery();
			List<Prescription> list2 = new ArrayList<>();
			while (res.next()) {
				Prescription pre = new Prescription();
				pre.setDrugs(res.getString("drugs"));

				list2.add(pre);

			}

			details.setPrescriptions(list2);
			details.setTests(list);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return details;
	}

}
