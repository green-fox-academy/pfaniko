package com.greenfoxacademy.todo;

import com.greenfoxacademy.todo.model.Todo;
import com.greenfoxacademy.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {
  public TodoRepository repository;

  @Autowired
  public TodoApplication(TodoRepository repository) {
    this.repository = repository;
  }

  public static void main(String[] args) {
    SpringApplication.run(TodoApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    repository.save(new Todo("I have to learn Object Relational Mapping"));
    repository.save(new Todo("I have to complete this Todo Application"));
  }
}
