package com.sarvesh.hms.dto;

import java.util.List;

public class PrescriptionDetails {

	private String prescriptionId;
	private String diagnosisId;
	
	private String patientName;
	private String docrotName;
	
	private List<Prescription> prescriptions;
	private List<Tests> tests;
	
	private String remark;
    private String docDegree;
    
    

	public String getDocDegree() {
		return docDegree;
	}

	public void setDocDegree(String docDegree) {
		this.docDegree = docDegree;
	}

	public String getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(String diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	public String getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(String prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDocrotName() {
		return docrotName;
	}

	public void setDocrotName(String docrotName) {
		this.docrotName = docrotName;
	}

	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public List<Tests> getTests() {
		return tests;
	}

	public void setTests(List<Tests> tests) {
		this.tests = tests;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

	@Override
	public String toString() {
		return "PrescriptionDetails [prescriptionId=" + prescriptionId + ", diagnosisId=" + diagnosisId
				+ ", patientName=" + patientName + ", docrotName=" + docrotName + ", prescriptions=" + prescriptions
				+ ", tests=" + tests + ", remark=" + remark + ", docDegree=" + docDegree + "]";
	}

}
