package com.dxc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.model.Demo;
import com.dxc.model.Department;
import com.dxc.model.Product;
import com.dxc.model.Student;
import com.dxc.repository.CollegeRepository;
import com.dxc.repository.CollegeStudentRepository;

@Service
public class CollegeService {

	@Autowired
	private CollegeRepository collegeRepository; 
	
	@Autowired
	private CollegeStudentRepository collegeStudentRepository;
	
	public List<Department> getalldetails()
	{
		List<Department> dept = new ArrayList<>();
		collegeRepository.findAll().forEach(dept::add);
		return dept;
		
	}
	
	public void addDepartment(Department department)
	{
		collegeRepository.save(department);
	}

	public List<Student> getallstudents() {
		List<Student> stud = new ArrayList<>();
		collegeStudentRepository.findAll().forEach(stud::add);
		return stud;
	}

	public void addStudent(Student student) {

		collegeStudentRepository.save(student);
		
	}

	public Student saveStudent(Demo demo) {
		// TODO Auto-generated method stub
		Department department = collegeRepository.findById(demo.departmentid);
		Student student = new Student();
		student.setStudentname(demo.studentname);
		student.setStudentcity(demo.studentcity);
		student.setDepartment(department);
		return collegeStudentRepository.save(student);
	}
}
