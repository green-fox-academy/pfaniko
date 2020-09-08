package com.greenfoxacademy.todo.controller;

import com.greenfoxacademy.todo.model.Todo;
import com.greenfoxacademy.todo.repository.TodoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class TodoController {
  private TodoRepository repository;

  @Autowired
  public TodoController(TodoRepository repository) {
    this.repository = repository;
  }

  @RequestMapping(value = {"/", "/list"})
  public String list(Model model) {
    List<Todo> todos = new ArrayList<>();
    repository.findAll().forEach(todos::add);
    model.addAttribute("todos",todos);
    return "todolist";
  }
}