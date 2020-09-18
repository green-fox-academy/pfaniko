package com.greenfoxacademy.rest.models.sithsentence;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
  @JsonProperty("sith_text")
  private String sithText;

  public Response(String sithText) {
    this.sithText = sithText;
  }

  public String getSithText() {
    return sithText;
  }
}
