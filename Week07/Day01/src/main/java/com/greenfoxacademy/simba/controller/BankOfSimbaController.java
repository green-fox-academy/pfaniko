package com.greenfoxacademy.simba.controller;

import com.greenfoxacademy.simba.model.BankAccount;
import com.greenfoxacademy.simba.repository.Bank;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BankOfSimbaController {
  private Bank bank = new Bank();
  BankAccount bankAccount = new BankAccount("Simba", 2000, "lion");

  @RequestMapping("/show")
  public String addBankAccount(Model model) {
    model.addAttribute("bankAccount", bankAccount);
    return "index";
  }

  @RequestMapping("/display-string")
  public String displayString(Model model) {
    String displayedString = "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";
    model.addAttribute("displayedString", displayedString);
    return "display-string";
  }

  @RequestMapping("/all-accounts")
  public String displayAllAccounts(Model model) {
    model.addAttribute("bankAccounts", bank.getBankAccounts());
    return "all-accounts";
  }
}