package com.greenfoxacademy.foxclub.repositories;

import com.greenfoxacademy.foxclub.models.Fox;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoxRepository extends CrudRepository<Fox, Long> {
  List<Fox> findAll();

  Fox findByName(String name);
}