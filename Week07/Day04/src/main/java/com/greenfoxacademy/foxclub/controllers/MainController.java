package com.greenfoxacademy.foxclub.controllers;

import com.greenfoxacademy.foxclub.models.Fox;
import com.greenfoxacademy.foxclub.repositories.FoxList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
  private FoxList foxList;

  @Autowired
  public MainController(FoxList foxList) {
    this.foxList = foxList;
  }

  @RequestMapping("/")
  public String renderWebsite(@RequestParam(required = false) String name, Model model) {
    Fox myFox = getFox(name);
    model.addAttribute("myFox", myFox);
    return "index";
  }

  @GetMapping("/login")
  public String renderLogin() {
    return "login";
  }

  @PostMapping("/login")
  public String loginUser(@RequestParam(required = false) String name) {
    foxList.addNewFox(name);
    return "redirect:/?name=" + name;
  }

  private Fox getFox( String name) {
    return foxList.getFoxes().stream()
          .filter(fox1 -> fox1.getName().equals(name))
          .findFirst()
          .get();
  }
}