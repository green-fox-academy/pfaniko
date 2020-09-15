package com.greenfoxacademy.rest.models;

public class NoInputError {
  private String error;

  public NoInputError(String error) {
    this.error = error;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
