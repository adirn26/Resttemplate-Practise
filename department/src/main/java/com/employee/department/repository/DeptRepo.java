package com.employee.department.repository;

import com.employee.department.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeptRepo extends MongoRepository<Department, Integer> {

}
