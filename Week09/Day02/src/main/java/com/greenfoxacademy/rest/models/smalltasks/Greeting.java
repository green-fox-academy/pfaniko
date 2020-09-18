package com.greenfoxacademy.rest.models.smalltasks;

public class Greeting {
  private String welcome_message;

  public Greeting(String name, String title) {
    this.welcome_message = "Oh, hi there " + name + ", my dear " + title + "!";
  }

  public String getWelcome_message() {
    return welcome_message;
  }
}