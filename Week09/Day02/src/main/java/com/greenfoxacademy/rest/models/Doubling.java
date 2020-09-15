package com.greenfoxacademy.rest.models;

public class Doubling {
  private int received;
  private int result;

  public Doubling(int input) {
    this.received = input;
    this.result = 2*input;
  }

  public int getReceived() {
    return received;
  }

  public int getResult() {
    return result;
  }

  public void setReceived(int received) {
    this.received = received;
  }

  public void setResult(int result) {
    this.result = result;
  }
}
