package com.java.spring.beans;

public class StudentBean {
	private int studId;
	private String studName;
	private String address;
	private String gender;
	private double fees;
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "StudentBean [studId=" + studId + ", studName=" + studName + ", address=" + address + ", gender="
				+ gender + ", fees=" + fees + "]";
	}
	public StudentBean(int studId, String studName, String address, String gender, double fees) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.address = address;
		this.gender = gender;
		this.fees = fees;
	}
	public StudentBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
