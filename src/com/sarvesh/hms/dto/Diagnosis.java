package com.sarvesh.hms.dto;

public class Diagnosis {
	
	private Long id;
	private String remark;
	private String doctorId ;
	private String patientId;
	private String appoId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getAppoId() {
		return appoId;
	}
	public void setAppoId(String appoId) {
		this.appoId = appoId;
	}
	
	@Override
	public String toString() {
		return "Diagnosis [id=" + id + ", remark=" + remark + ", doctorId=" + doctorId + ", patientId=" + patientId
				+ ", appoId=" + appoId + "]";
	}
	
	
	
	
	
	

}
