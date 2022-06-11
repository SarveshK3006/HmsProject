package com.sarvesh.hms.dto;

public class Prescription {
	
	private String id;
	private String patientId;
	private String doctorId;
	private String diagnosisId;
	private String drugs;
	private String remark;
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
	public String getDrugs() {
		return drugs;
	}
	public void setDrugs(String drugs) {
		this.drugs = drugs;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Prescription [id=" + id + ", patientId=" + patientId + ", doctorId=" + doctorId + ", diagnosisId="
				+ diagnosisId + ", drugs=" + drugs + ", remark=" + remark + "]";
	}

	
	
	
	

}
