package com.employee.demo.service;

import com.employee.demo.model.Department;
import com.employee.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmpService {
    public void createEmp(Employee employee);

    public List<Employee> getAllEmp();

    public Employee getByEmpId(int id);

    public void UpdateEmp(int id, Employee employee);

    public void DeleteEmp(int id);

    public Department getdept(int id);
}
