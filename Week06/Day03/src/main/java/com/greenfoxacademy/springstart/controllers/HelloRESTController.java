package com.greenfoxacademy.springstart.controllers;

import com.greenfoxacademy.springstart.models.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRESTController {

  @RequestMapping(value = "/greeting1")
  @ResponseBody
  public Greeting returnGreeting() {
    return new Greeting(1, "Hello, World!");
  }

  @RequestMapping(value = "/greeting")
  @ResponseBody
  public Greeting returnGreeting(@RequestParam String name) {
    return new Greeting(1, "Hello, " + name);
  }
}