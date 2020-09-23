package com.greenfoxacademy.todosql.controller;

import com.greenfoxacademy.todosql.model.Todo;
import com.greenfoxacademy.todosql.repository.AssigneeRepository;
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
  private final AssigneeRepository assigneeRepository;

  @Autowired
  public TodoController(TodoRepository todoRepository, AssigneeRepository assigneeRepository) {
    this.todoRepository = todoRepository;
    this.assigneeRepository = assigneeRepository;
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
    return "main";
  }

  @GetMapping("/add")
  public String renderAddTodo(Model model) {
    model.addAttribute("todo", new Todo());
    return "/todo/addtodo";
  }

  @GetMapping("/{id}/edit")
  public String renderEditTodo(@PathVariable long id, Model model) {
    Todo todoToEdit = todoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    model.addAttribute("todoToEdit", todoToEdit);
    model.addAttribute("allAssignees", assigneeRepository.findAll());
    return "todo/edittodo";
  }

  @PostMapping("/add")
  public String addNewTodo(@ModelAttribute Todo newTodo) {
    newTodo.setAssignee(assigneeRepository.findAssigneeByName(""));
    todoRepository.save(newTodo);
    return "redirect:/todo/";
  }

  @PostMapping("/{id}/edit")
  public String editTodo(@ModelAttribute Todo todoToEdit) {
    modifySelectedTodo(todoToEdit);
    return "redirect:/todo/";
  }

  @PostMapping("/{id}/delete")
  public String deleteTodo(@PathVariable long id) {
    todoRepository.deleteById(id);
    return "redirect:/todo/";
  }

  private void modifySelectedTodo(Todo todoToEdit) {
    todoRepository.save(todoToEdit);
  }
}