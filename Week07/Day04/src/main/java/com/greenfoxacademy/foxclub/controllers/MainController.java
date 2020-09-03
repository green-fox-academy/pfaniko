package com.greenfoxacademy.foxclub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/")
  public String renderWebsite() {
    return "index";
  }

  @GetMapping("/login")
  public String renderLogin() {
    return "login";
  }
}