package com.greenfoxacademy.rest.models;

public class Appended {
  private String appended;

  public Appended(String appendable) {
    this.appended = appendable + 'a';
  }

  public String getAppended() {
    return appended;
  }

  public void setAppended(String appended) {
    this.appended = appended;
  }
}
