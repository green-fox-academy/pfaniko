package com.greenfoxacademy.rest.repositories;

import com.greenfoxacademy.rest.models.log_entries.Log;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<Log, Integer> {

  @Override
  List<Log> findAll();
}
