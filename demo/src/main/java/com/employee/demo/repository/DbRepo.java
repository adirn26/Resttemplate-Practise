package com.employee.demo.repository;

import com.employee.demo.model.DbSequence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DbRepo extends MongoRepository<DbSequence, String> {
}
