package com.greenfoxacademy.todosql;

import com.greenfoxacademy.todosql.model.Assignee;
import com.greenfoxacademy.todosql.model.Todo;
import com.greenfoxacademy.todosql.repository.AssigneeRepository;
import com.greenfoxacademy.todosql.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodosqlApplication implements CommandLineRunner {
  public TodoRepository todoRepository;
  public AssigneeRepository assigneeRepository;

  @Autowired
  public TodosqlApplication(TodoRepository todoRepository, AssigneeRepository assigneeRepository) {
    this.todoRepository = todoRepository;
    this.assigneeRepository = assigneeRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(TodosqlApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Assignee a = new Assignee("Ani","ani@gmail.com");
    assigneeRepository.save(a);
    todoRepository.save(new Todo("daily task", false, false, a));
    todoRepository.save(new Todo("make the bed", true, true, a));
    todoRepository.save(new Todo("do the washing up", true, false, a));
    todoRepository.save(new Todo("clean the bathroom and the kitchen", true, true, a));
    todoRepository.save(new Todo("wipe all the surfaces with a cloth", true, false, a));
    todoRepository.save(new Todo("remove the grease", true, true, a));
  }
}