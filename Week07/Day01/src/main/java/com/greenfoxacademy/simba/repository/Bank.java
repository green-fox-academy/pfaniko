package com.greenfoxacademy.simba.repository;

import com.greenfoxacademy.simba.model.BankAccount;
import java.util.ArrayList;
import java.util.List;

public class Bank {
  private List<BankAccount> bankAccounts;

  public Bank() {
    this.bankAccounts = new ArrayList<>();
    bankAccounts.add(new BankAccount("Timon", 1500, "meerkat", false));
    bankAccounts.add(new BankAccount("Pumbaa", 3500, "warthog", false));
    bankAccounts.add(new BankAccount("Rafiki", 1500, "mandrill", false));
    bankAccounts.add(new BankAccount("Scar", 1000, "lion", true));
    bankAccounts.add(new BankAccount("Simba", 2000, "lion", false));
  }

  public List<BankAccount> getBankAccounts() {
    return bankAccounts;
  }

  public void setBankAccounts(List<BankAccount> bankAccounts) {
    this.bankAccounts = bankAccounts;
  }
}