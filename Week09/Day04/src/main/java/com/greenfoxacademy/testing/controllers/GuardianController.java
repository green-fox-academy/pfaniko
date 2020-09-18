package com.greenfoxacademy.testing.controllers;

import com.greenfoxacademy.testing.services.GuardianService;
import com.greenfoxacademy.testing.models.NoInputError;
import com.greenfoxacademy.testing.models.TranslatedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuardianController {
  private final GuardianService guardianService;

  @Autowired
  public GuardianController(GuardianService guardianService) {
    this.guardianService = guardianService;
  }

  @GetMapping("/groot")
  public ResponseEntity<Object> translateMessage(@RequestParam(required = false) String message) {
    if (message == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new NoInputError("I am Groot!"));
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(new TranslatedMessage(message));
    }
  }

  @GetMapping("/yondu")
  public ResponseEntity<Object> calculateSpeed(@RequestParam(required = false) Double distance,
                                               @RequestParam(required = false) Double time) {
    if (distance == null || time == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new NoInputError("Please provide both the distance and the time!"));
    } else {
      return ResponseEntity.status(HttpStatus.OK)
          .body(guardianService.createSpeedData(distance, time));
    }
  }
}