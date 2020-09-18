package com.greenfoxacademy.testing.models;

public class TranslatedMessage {
  private String received;
  private String translated;

  public TranslatedMessage(String received) {
    this.received = received;
    this.translated = "I am Groot!";
  }

  public String getReceived() {
    return received;
  }

  public String getTranslated() {
    return translated;
  }
}
