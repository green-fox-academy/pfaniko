package com.greenfoxacademy.rest.controllers;

import com.greenfoxacademy.rest.models.Greeting;
import com.greenfoxacademy.rest.models.NoInputError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  @GetMapping("/greeter")
  public ResponseEntity<Object> getGreeting(@RequestParam (required = false) String title, @RequestParam (required = false) String name) {
    if (name == null && title == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new NoInputError("Please provide a name and a title!"));
    } else if (name == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new NoInputError("Please provide a name!"));
    } else if (title == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new NoInputError("Please provide a title!"));
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(new Greeting(name, title));
    }
  }
}
