package com.greenfoxacademy.simba.model;

public class BankAccount {
  private String name;
  private int balance;
  private String animalType;
  private Boolean isKing;
  private Boolean isBad;

  public BankAccount(String name, int balance, String animalType, Boolean isBad) {
    this.name = name;
    this.balance = balance;
    this.animalType = animalType;
    this.isKing = name.equals("Simba");
    this.isBad = isBad;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public String getAnimalType() {
    return animalType;
  }

  public void setAnimalType(String animalType) {
    this.animalType = animalType;
  }

  public Boolean isKing() {
    return isKing;
  }

  public void setKing(Boolean king) {
    isKing = king;
  }

  public Boolean isBad() {
    return isBad;
  }

  public void setBad(Boolean bad) {
    isBad = bad;
  }
}