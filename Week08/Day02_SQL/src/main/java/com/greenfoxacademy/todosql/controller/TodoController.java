package com.greenfoxacademy.todosql.controller;

import com.greenfoxacademy.todosql.model.Todo;
import com.greenfoxacademy.todosql.repository.TodoRepository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo")
public class TodoController {
  private final TodoRepository todoRepository;

  @Autowired
  public TodoController(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @GetMapping(value = {"/", "/list"})
  public String list(@RequestParam(required = false) Boolean isActive, Model model) {
    List<Todo> actives = todoRepository.findAll().stream().filter(todo -> !todo.isDone()).collect(
        Collectors.toList());
    List<Todo> notActives = todoRepository.findAll().stream().filter(Todo::isDone).collect(
        Collectors.toList());
    if (isActive == null) {
      model.addAttribute("todos", todoRepository.findAll());
    } else if (isActive) {
      model.addAttribute("todos", actives);
    } else {
      model.addAttribute("todos", notActives);
    }
    return "todolist";
  }

  @GetMapping("/add")
  public String renderAddTodo() {
    return "addtodo";
  }

  @GetMapping("/{id}/edit")
  public String renderEditTodo(@PathVariable long id, Model model) {
    Todo myTodo = todoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    model.addAttribute("todo", myTodo);
    return "edittodo";
  }

  @PostMapping("/add")
  public String addNewTodo(String newTodo) {
    todoRepository.save(new Todo(newTodo));
    return "redirect:/todo/";
  }

  @PostMapping("/{id}/delete")
  public String deleteTodo(@PathVariable long id) {
    todoRepository.deleteById(id);
    return "redirect:/todo/";
  }

  @PostMapping("/{id}/edit")
  public String editTodo(@PathVariable long id, String title, boolean isUrgent, boolean isDone) {
    modifySelectedTodoWithInput(id, title, isUrgent, isDone);
    return "redirect:/todo/";
  }

  private void modifySelectedTodoWithInput(long id, String title, boolean isUrgent,
                                                  boolean isDone) {
    Todo mytodo = todoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    mytodo.setTitle(title);
    mytodo.setUrgent(isUrgent);
    mytodo.setDone(isDone);
    todoRepository.save(mytodo);
  }
}