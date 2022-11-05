package com.employee.department.service;

import com.employee.department.model.DbSequence;
import com.employee.department.model.Department;
import com.employee.department.repository.DbRepo;
import com.employee.department.repository.DeptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Deptimpl implements DeptService{

    @Autowired
    DeptRepo deptRepo;

    @Autowired
    DbRepo dbRepo;

    @Override
    public void create(Department department) {
        DbSequence db = dbRepo.findById("deptseq").get();
        db.setSeq(db.getSeq()+1);
        dbRepo.save(db);
        department.setId(db.getSeq());
        deptRepo.save(department);
    }

    @Override
    public List<Department> getall() {
        return deptRepo.findAll();
    }

    @Override
    public Department getById(int id) {
        return deptRepo.findById(id).get();
    }

    @Override
    public void updatedept(int id, Department department) {
        department.setId(id);
        deptRepo.save(department);
    }

    @Override
    public void deleteDept(int id) {
        deptRepo.deleteById(id);
    }
}
