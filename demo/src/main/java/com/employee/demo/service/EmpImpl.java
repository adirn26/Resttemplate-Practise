package com.employee.demo.service;

import com.employee.demo.model.DbSequence;
import com.employee.demo.model.Department;
import com.employee.demo.model.Employee;
import com.employee.demo.repository.DbRepo;
import com.employee.demo.repository.EmpRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpImpl implements EmpService {


    private static final Logger logger = LoggerFactory.getLogger(EmpService.class);
    @Autowired
    EmpRepo repo;

    @Autowired
    DbRepo dbRepo;

    @Override
    public void createEmp(Employee employee) {
        DbSequence db = dbRepo.findById("seq").get();
        db.setSeq(db.getSeq()+1);
        dbRepo.save(db);
        employee.setId(db.getSeq());
        repo.save(employee);
    }

    @Override
    public List<Employee> getAllEmp() {
        return repo.findAll();
    }

    @Override
    public Employee getByEmpId(int id) {
       return repo.findById(id).get();
    }

    @Override
    public void UpdateEmp(int id, Employee employee) {
        employee.setId(id);
        repo.save(employee);
    }

    @Override
    public void DeleteEmp(int id) {
        repo.deleteById(id);
    }

    @Override
    public Department getdept(int id) {
        String uri = "http://localhost:9902/dept/{id}";
        Map<String,Integer> uriparam = new HashMap<>();
        uriparam.put("id", id);
        RestTemplate restTemplate = new RestTemplate();
        Department res = restTemplate.getForObject(uri,Department.class, uriparam );
        logger.info(res.toString());
        return res;
    }
}
