package com.java.spring.beans;

public class Employee {

	private int empId;
	private String empName;
	private String address;
	private double salary;
	private String emialID;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmialID() {
		return emialID;
	}
	public void setEmialID(String emialID) {
		this.emialID = emialID;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", address=" + address + ", salary=" + salary
				+ ", emialID=" + emialID + "]";
	}
	public Employee(int empId, String empName, String address, double salary, String emialID) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.address = address;
		this.salary = salary;
		this.emialID = emialID;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
