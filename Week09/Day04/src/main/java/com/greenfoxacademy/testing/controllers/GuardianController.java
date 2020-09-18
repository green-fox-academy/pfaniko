package com.greenfoxacademy.testing.controllers;

import com.greenfoxacademy.testing.models.NoInputError;
import com.greenfoxacademy.testing.models.TranslatedMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuardianController {

  @GetMapping("/groot")
  public ResponseEntity<Object> translateMessage(@RequestParam (required = false) String message) {
    if (message == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new NoInputError("I am Groot!"));
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(new TranslatedMessage(message));
    }
  }
}