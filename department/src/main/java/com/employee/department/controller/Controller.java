package com.employee.department.controller;

import com.employee.department.DepartmentApplication;
import com.employee.department.model.Department;
import com.employee.department.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    DeptService deptService;

    @GetMapping("/dept")
    public ResponseEntity<?> getall(){
        List<Department> dps = deptService.getall();
        return new ResponseEntity<List<Department>>(dps, HttpStatus.OK);
    }

    @GetMapping("/dept/{id}")
    public ResponseEntity<?> getbyId(@PathVariable int id){
        Department dp = deptService.getById(id);
        return new ResponseEntity<Department>(dp, HttpStatus.OK);
    }

    @PostMapping("/dept")
    public ResponseEntity<?> insertemp(@RequestBody Department department){
        deptService.create(department);
        return new ResponseEntity<>("Department created", HttpStatus.OK);
    }

    @PutMapping("/dept/{id}")
    public ResponseEntity<?> updateemp(@PathVariable int id, @RequestBody Department department){
        deptService.updatedept(id, department);
        return new ResponseEntity<>("Department updated", HttpStatus.OK);
    }

    @DeleteMapping("/dept/{id}")
    public ResponseEntity<?> deleteemp(@PathVariable int id){
        deptService.deleteDept(id);
        return new ResponseEntity<>("department Deleted", HttpStatus.OK);
    }
}
