package com.greenfoxacademy.todosql;

import com.greenfoxacademy.todosql.model.Todo;
import com.greenfoxacademy.todosql.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodosqlApplication implements CommandLineRunner {
  public TodoRepository repository;

  @Autowired
  public TodosqlApplication(TodoRepository repository) {
    this.repository = repository;
  }

  public static void main(String[] args) {
    SpringApplication.run(TodosqlApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    repository.save(new Todo("daily task", false, false));
    repository.save(new Todo("make the bed", true, true));
    repository.save(new Todo("do the washing up", true, false));
    repository.save(new Todo("clean the bathroom and the kitchen", true, true));
    repository.save(new Todo("wioe all the surfaces with a cloth", true, false));
    repository.save(new Todo("remove the grease", true, true));
  }
}