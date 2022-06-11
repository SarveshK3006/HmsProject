package com.sarvesh.hms.dto;

public class Tests {

	private String id ;
	private String patientId;
	private String doctorId;
	private String diagnosisId;
	private String remark;
	private String tests;
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTests() {
		return tests;
	}
	public void setTests(String tests) {
		this.tests = tests;
	}
	@Override
	public String toString() {
		return "Tests [id=" + id + ", patientId=" + patientId + ", doctorId=" + doctorId + ", diagnosisId="
				+ diagnosisId + ", remark=" + remark + ", tests=" + tests + "]";
	}
	
	
	
	
	
}
