package com.dxc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dxc.model.Department;

@Repository
public interface CollegeRepository extends CrudRepository<Department, Long> {

	Department findById(long departmentid);
}
