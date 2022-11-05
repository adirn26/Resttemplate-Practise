package com.employee.department.repository;

import com.employee.department.model.DbSequence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DbRepo extends MongoRepository<DbSequence, String> {
}
