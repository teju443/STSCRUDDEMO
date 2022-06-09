package com.dxc.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long departmentid;
	
	private String departmentname;
	
	
	  @JsonIgnore 
	  //@OneToMany(mappedBy = "department",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	  @OneToMany
	  @JoinColumn(name="department_id",referencedColumnName = "departmentid")
	  private List<Student> students;
	 

    public Department()
    {
    	super();
    }
	
	public Department(long departmentid, String departmentname) {
		super();
		this.departmentid = departmentid;
		this.departmentname = departmentname;
	}
	
	
	
	public Department(long departmentid, String departmentname, List<Student> students) {
		super();
		this.departmentid = departmentid;
		this.departmentname = departmentname;
		this.students = students;
	}

	public long getDepartmentid() {
		return departmentid;
	}


	public void setDepartmentid(long departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Department [departmentid=" + departmentid + ", departmentname=" + departmentname + ", students="
				+ students + "]";
	}
	
	
}
