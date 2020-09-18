package com.greenfoxacademy.rest.models.sithsentence;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YodaSentence {
  @JsonProperty("sith_text")
  private String sithText;

  public YodaSentence(String sithText) {
    this.sithText = sithText;
  }

  public String getSithText() {
    return sithText;
  }
}
