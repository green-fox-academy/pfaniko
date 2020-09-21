package com.greenfoxacademy.todosql.repository;

import com.greenfoxacademy.todosql.model.Assignee;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AssigneeRepository extends CrudRepository<Assignee, Integer> {
  @Override
  List<Assignee> findAll();
}