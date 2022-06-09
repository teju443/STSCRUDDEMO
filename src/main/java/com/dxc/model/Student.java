package com.dxc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentid;
	
	private String studentname;
	private String studentcity;
	
	@ManyToOne
    @JoinColumn(name="department_id",referencedColumnName = "departmentid")
    private Department department;
	
	public Student()
	{
		super();
	}
	
	public Student(long studentid, String studentname, String studentcity) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentcity = studentcity;
	}
	
	

	public Student(long studentid, String studentname, String studentcity, Department department) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentcity = studentcity;
		this.department = department;
	}

	public long getStudentid() {
		return studentid;
	}

	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentcity() {
		return studentcity;
	}

	public void setStudentcity(String studentcity) {
		this.studentcity = studentcity;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", studentname=" + studentname + ", studentcity=" + studentcity
				+ ", department=" + department + "]";
	}
	
	
}
