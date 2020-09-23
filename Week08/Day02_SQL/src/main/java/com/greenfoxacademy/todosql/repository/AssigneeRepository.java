package com.greenfoxacademy.todosql.repository;

import com.greenfoxacademy.todosql.model.Assignee;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AssigneeRepository extends CrudRepository<Assignee, Long> {
  @Override
  List<Assignee> findAll();

  Assignee findAssigneeByName(String name);
}