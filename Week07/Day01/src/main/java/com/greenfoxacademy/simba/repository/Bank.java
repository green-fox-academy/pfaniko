package com.greenfoxacademy.simba.repository;

import com.greenfoxacademy.simba.model.BankAccount;
import java.util.ArrayList;
import java.util.List;

public class Bank {
  private List<BankAccount> bankAccounts;

  public Bank() {
    this.bankAccounts = new ArrayList<>();
    bankAccounts.add(new BankAccount("Timon", 1500, "meerkat"));
    bankAccounts.add(new BankAccount("Pumbaa", 3500, "warthog"));
    bankAccounts.add(new BankAccount("Rafiki", 1500, "mandrill"));
    bankAccounts.add(new BankAccount("Nala", 6500, "lion"));
    bankAccounts.add(new BankAccount("Simba", 2000, "lion"));
  }

  public List<BankAccount> getBankAccounts() {
    return bankAccounts;
  }

  public void setBankAccounts(List<BankAccount> bankAccounts) {
    this.bankAccounts = bankAccounts;
  }
}