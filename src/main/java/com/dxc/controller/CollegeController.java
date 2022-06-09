package com.dxc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.model.Demo;
import com.dxc.model.Department;
import com.dxc.model.Product;
import com.dxc.model.Student;
import com.dxc.repository.CollegeStudentRepository;
import com.dxc.service.CollegeService;
import com.dxc.service.ProductService;

@RestController
public class CollegeController {

	@Autowired
	private CollegeService collegeService;
	
	
	@GetMapping("/department")
	public List<Department> getAllDetails()
	{
		return collegeService.getalldetails();
	
	}
	
	@PostMapping("/department")
	public void addDepartment(@RequestBody Department department)
	{
		collegeService.addDepartment(department);
	}
	
	@GetMapping("/student")
	public List<Student> getAllstudents()
	{
		return collegeService.getallstudents();
	}
	
	@PostMapping("/student")
	public void addStudent(@RequestBody Student student)
	{
		collegeService.addStudent(student);
	}
	
	@PostMapping("/savestudent")
	public Student saveStudent(@RequestBody Demo demo)
	{
		return collegeService.saveStudent(demo);
	}
}