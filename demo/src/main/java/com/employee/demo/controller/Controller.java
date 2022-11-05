package com.employee.demo.controller;

import com.employee.demo.model.Department;
import com.employee.demo.model.Employee;
import com.employee.demo.model.OutputModel;
import com.employee.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    EmpService empService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/emp")
    public ResponseEntity<?> getall(){
        List<Employee> emps = empService.getAllEmp();
        return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
    }

    @GetMapping("/emp/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        Employee emp = empService.getByEmpId(id);
        OutputModel out = new OutputModel();
        out.setId(emp.getId());
        out.setEmpname(emp.getName());
        out.setDeptno(emp.getDeptno());
        Department dep = empService.getdept(emp.getDeptno());
        out.setDeptname(dep.getDeptName());
        return new ResponseEntity<OutputModel>(out, HttpStatus.OK);
    }

    @PostMapping("/emp")
    public ResponseEntity<?> insertemp(@RequestBody Employee employee){
        empService.createEmp(employee);
        return new ResponseEntity<>("Employee created", HttpStatus.OK);
    }

    @PutMapping("/emp/{id}")
    public ResponseEntity<?> updateemp(@PathVariable int id, @RequestBody Employee employee){
        empService.UpdateEmp(id, employee);
        return new ResponseEntity<>("Employee updated", HttpStatus.OK);
    }

    @DeleteMapping("/emp/{id}")
    public ResponseEntity<?> deleteemp(@PathVariable int id){
        empService.DeleteEmp(id);
        return new ResponseEntity<>("Employee Deleted", HttpStatus.OK);
    }
}
