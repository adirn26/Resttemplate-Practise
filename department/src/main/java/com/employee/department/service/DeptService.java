package com.employee.department.service;

import com.employee.department.model.Department;

import java.util.List;

public interface DeptService {

    public void create(Department department);

    public List<Department>  getall();

    public Department getById(int id);

    public void updatedept(int id, Department department);

    public void deleteDept(int id);
}
