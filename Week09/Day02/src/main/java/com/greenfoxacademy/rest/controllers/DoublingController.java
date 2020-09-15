package com.greenfoxacademy.rest.controllers;

import com.greenfoxacademy.rest.models.Doubling;
import com.greenfoxacademy.rest.models.NoInputError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoublingController {

  @GetMapping("/doubling")
  public ResponseEntity<Object> getDoubling(@RequestParam(required = false) Integer input) {
    if (input == null) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(new NoInputError("Please provide an input!"));
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(new Doubling(input));
    }
  }
}