package com.sarvesh.hms.dto;

import java.time.LocalDate;
import java.util.Date;

public class Appointment {

	private long id;
	private String patientId;
	private String doctorId;
	private String diagnosisId;
	private LocalDate appDate;
	private String isDiagnosed;
	private String remark;
	private String timeSlot;
	
	
	

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(String diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	public LocalDate getAppDate() {
		return appDate;
	}

	public void setAppDate(LocalDate appDate) {
		this.appDate = appDate;
	}

	public String getIsDiagnosed() {
		return isDiagnosed;
	}

	public void setIsDiagnosed(String isDiagnosed) {
		this.isDiagnosed = isDiagnosed;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", patientId=" + patientId + ", doctorId=" + doctorId + ", diagnosisId="
				+ diagnosisId + ", appDate=" + appDate + ", isDiagnosed=" + isDiagnosed + ", remark=" + remark
				+ ", timeSlot=" + timeSlot + "]";
	}

}
