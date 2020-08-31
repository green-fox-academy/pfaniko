package com.greenfoxacademy.simba.controller;

import com.greenfoxacademy.simba.model.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BankOfSimbaController {

  @RequestMapping("/show")
  public String addBankAccount(Model model) {
    BankAccount bankAccount = new BankAccount("Simba", 2000, "lion");
    model.addAttribute("bankAccount", bankAccount);
    return "index";
  }

  @RequestMapping("/display-string")
  public String displayString(Model model) {
    String displayedString = "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";
    model.addAttribute("displayedString", displayedString);
    return "display-string";
  }
}

  @RequestMapping("/all-accounts")
  public String displayString(Model model) {


    return "all-accounts";
  }