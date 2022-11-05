package com.employee.demo.repository;


import com.employee.demo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpRepo extends MongoRepository<Employee, Integer> {

}
