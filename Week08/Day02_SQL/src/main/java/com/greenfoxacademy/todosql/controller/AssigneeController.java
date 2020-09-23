package com.greenfoxacademy.todosql.controller;

import com.greenfoxacademy.todosql.model.Assignee;
import com.greenfoxacademy.todosql.repository.AssigneeRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("todo/assignee")
public class AssigneeController {
  private final AssigneeRepository assigneeRepository;

  @Autowired
  public AssigneeController(
      AssigneeRepository assigneeRepository) {
    this.assigneeRepository = assigneeRepository;
  }

  @GetMapping("/")
  public String renderAssigneePage(Model model) {
    model.addAttribute("assignees", assigneeRepository.findAll());
    return "assignee/assignees";
  }

  @GetMapping("/add")
  public String renderAddAssignee(Model model) {
    model.addAttribute("assignee", new Assignee());
    return "/assignee/addassignee";
  }

  @GetMapping("/{id}/edit")
  public String renderEditAssignee(@PathVariable long id, Model model) {
    Assignee assigneeToEdit =
        assigneeRepository.findById(id).orElseThrow(NoSuchElementException::new);
    model.addAttribute("assigneeToEdit", assigneeToEdit);
    return "assignee/editassignee";
  }

  @PostMapping("/add")
  public String addNewAssignee(@ModelAttribute Assignee assignee) {
    assigneeRepository.save(assignee);
    return "redirect:/todo/assignee";
  }

  @PostMapping("/{id}/edit")
  public String editAssignee(@PathVariable long id, @ModelAttribute Assignee editedAssignee) {
    modifySelectedAssignee(editedAssignee);
    return "redirect:/todo/assignee/";
  }

  @PostMapping("/{id}/delete")
  public String deleteAssignee(@PathVariable long id) {
    assigneeRepository.deleteById(id);
    return "redirect:/todo/";
  }

  private void modifySelectedAssignee(Assignee editedAssignee) {
    assigneeRepository.save(editedAssignee);
  }
}
