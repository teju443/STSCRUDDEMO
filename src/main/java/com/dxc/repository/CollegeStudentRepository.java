package com.dxc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dxc.model.Student;

@Repository
public interface CollegeStudentRepository extends CrudRepository<Student, Long> {

}
