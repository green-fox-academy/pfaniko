package com.greenfoxacademy.reddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedditController {

  @RequestMapping("/")
  public String renderMainPage() {
    return "index";
  }

  @RequestMapping("/submit")
  public String renderSubmitPage() {
    return "submit";
  }
}
