package com.greenfoxacademy.rest.controllers;

import com.greenfoxacademy.rest.models.log_entries.LogData;
import com.greenfoxacademy.rest.models.sith_sentence.SithSentence;
import com.greenfoxacademy.rest.models.small_tasks.Appended;
import com.greenfoxacademy.rest.models.array_handler.ArrayHandler;
import com.greenfoxacademy.rest.models.do_until.DoUntil;
import com.greenfoxacademy.rest.models.small_tasks.Doubling;
import com.greenfoxacademy.rest.models.small_tasks.Greeting;
import com.greenfoxacademy.rest.models.log_entries.Log;
import com.greenfoxacademy.rest.models.NoInputError;
import com.greenfoxacademy.rest.services.ArrayHandlerService;
import com.greenfoxacademy.rest.services.DoUntilService;
import com.greenfoxacademy.rest.services.LogService;
import com.greenfoxacademy.rest.services.SithService;
import java.util.Arrays;
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
  private ArrayHandlerService arrayHandlerService;
  private LogService logService;
  private SithService sithService;

  @Autowired
  public RController(DoUntilService doUntilService,
                     ArrayHandlerService arrayHandlerService, LogService logService, SithService sithService) {
    this.doUntilService = doUntilService;
    this.arrayHandlerService = arrayHandlerService;
    this.logService = logService;
    this.sithService = sithService;
  }

  @GetMapping("/doubling")
  public ResponseEntity<Object> getDoubling(@RequestParam(required = false) Integer input) {
    if (input == null) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(new NoInputError("Please provide an input!"));
    } else {
      logService.addLog(new Log("/doubling", "input=" + input.toString()));
      return ResponseEntity.status(HttpStatus.OK).body(new Doubling(input));
    }
  }

  @GetMapping("/appenda/{appendable}")
  public ResponseEntity appendA(@PathVariable(required = false) String appendable) {
    if (appendable == null) {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    } else {
      logService.addLog(new Log("/appenda/{appendable}", appendable));
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
      logService.addLog(new Log("/greeter", "title=" + title + "," + "name=" + name));
      return ResponseEntity.status(HttpStatus.OK).body(new Greeting(name, title));
    }
  }

  @PostMapping("/dountil/{action}")
  public ResponseEntity<Object> calculateResult(@PathVariable String action,
                                                @RequestBody DoUntil doUntil) {
    if (doUntil == null) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(new NoInputError("Please provide a number!"));
    } else {
      logService.addLog(
          new Log("/dountil/{action}", "action=" + action + "," + "number=" + doUntil.getUntil()));
      return ResponseEntity.status(HttpStatus.OK)
          .body(doUntilService.doActionUntilNumber(action, doUntil));
    }
  }

  @PostMapping("/arrays")
  public ResponseEntity<Object> calculateArrayResult(@RequestBody ArrayHandler arrayHandler) {
    if (arrayHandler.getWhat() == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new NoInputError("Please provide what to do with the numbers!"));
    } else if (arrayHandler.getNumbers() == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new NoInputError("Please provide the numbers!"));
    } else {
      logService.addLog(new Log("/arrays", "what=" + arrayHandler.getWhat() + "," + "numbers=" +
          Arrays.toString(arrayHandler.getNumbers())));
      return ResponseEntity.status(HttpStatus.OK)
          .body(arrayHandlerService.calculateResults(arrayHandler));
    }
  }

  @GetMapping("/log")
  public LogData getLogs() {
    return logService.fillLogEntries(new LogData());
  }

  @PostMapping ("/sith")
  public ResponseEntity <Object> getResponse (@RequestBody SithSentence sithSentence){
    return ResponseEntity.status(HttpStatus.OK).body(sithService.createYodaResponse(sithSentence.getText()));
  }
}