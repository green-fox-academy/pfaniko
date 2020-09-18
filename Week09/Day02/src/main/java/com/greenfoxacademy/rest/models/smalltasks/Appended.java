package com.greenfoxacademy.rest.models.smalltasks;

public class Appended {
  private String appended;

  public Appended(String appendable) {
    this.appended = appendable + 'a';
  }

  public String getAppended() {
    return appended;
  }
}