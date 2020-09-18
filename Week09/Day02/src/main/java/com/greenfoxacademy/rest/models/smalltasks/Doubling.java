package com.greenfoxacademy.rest.models.smalltasks;

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
}