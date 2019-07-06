package com.sample.microservicelogmanagement.repository;

import com.sample.microservicelogmanagement.model.Log;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface LogRepository extends CrudRepository<Log, UUID> {
}
