package com.sarvesh.hms.dto;

public class Diagnosis {
	
	private int id ;
	private String diagnosis ;
	private String prescreption ;
	private String recTests ;
	private String remark ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getPrescreption() {
		return prescreption;
	}
	public void setPrescreption(String prescreption) {
		this.prescreption = prescreption;
	}
	public String getRecTests() {
		return recTests;
	}
	public void setRecTests(String recTests) {
		this.recTests = recTests;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Diagnosis [id=" + id + ", diagnosis=" + diagnosis + ", prescreption=" + prescreption + ", recTests="
				+ recTests + ", remark=" + remark + "]";
	}
	
	
	

}
