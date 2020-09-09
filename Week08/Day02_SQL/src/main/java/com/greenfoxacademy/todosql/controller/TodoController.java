package com.greenfoxacademy.todosql.controller;

import com.greenfoxacademy.todosql.model.Todo;
import com.greenfoxacademy.todosql.repository.TodoRepository;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo")
public class TodoController {
  private TodoRepository repository;

  @Autowired
  public TodoController(TodoRepository repository) {
    this.repository = repository;
  }

  @RequestMapping(value = {"/","/list"})
  public String list(@RequestParam(required = false) boolean isActive, Model model) {
    if (isActive) {
      model.addAttribute("todos",
          repository.findAll().stream().filter(todo -> !todo.isDone()).collect(
              Collectors.toList()));
    } else {
      model.addAttribute("todos", repository.findAll());
    }
    return "todolist";
  }
}