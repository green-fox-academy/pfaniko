package com.greenfoxacademy.webshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebShopController {

  @RequestMapping (value="/webshop")
  public String getWebshop() {
    return "webshop";
  }
}
