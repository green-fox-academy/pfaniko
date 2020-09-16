package com.greenfoxacademy.rest.controllers;

import com.greenfoxacademy.rest.models.Appended;
import com.greenfoxacademy.rest.models.DoUntil;
import com.greenfoxacademy.rest.models.Doubling;
import com.greenfoxacademy.rest.models.Greeting;
import com.greenfoxacademy.rest.models.NoInputError;
import com.greenfoxacademy.rest.service.DoUntilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RController {
  private DoUntilService doUntilService;

  @Autowired
  public RController(DoUntilService doUntilService) {
    this.doUntilService = doUntilService;
  }

  @GetMapping("/doubling")
  public ResponseEntity<Object> getDoubling(@RequestParam(required = false) Integer input) {
    if (input == null) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(new NoInputError("Please provide an input!"));
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(new Doubling(input));
    }
  }

  @GetMapping("/appenda/{appendable}")
  public ResponseEntity<Object> appendA(@PathVariable(required = false) String appendable) {
    if (appendable == null) {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(new Appended(appendable));
    }
  }

  @GetMapping("/greeter")
  public ResponseEntity<Object> getGreeting(@RequestParam(required = false) String title,
                                            @RequestParam(required = false) String name) {
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

  @PostMapping("/dountil/{action}")
  public ResponseEntity<Object> getResult(@PathVariable String action,
                                          @RequestBody DoUntil doUntil) {
    if (doUntil == null) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(new NoInputError("Please provide a number!"));
    } else {
      return ResponseEntity.status(HttpStatus.OK)
          .body(doUntilService.doActionUntilNumber(action, doUntil));
    }
  }
}