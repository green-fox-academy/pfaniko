package com.greenfoxacademy.foxclub.models;

public enum Trick {
  WATCH("Watch TV"), PLAYFOOTBALL("Play football"),
  CIRCULATE("Circulate After Own Tail"),
  STEAL("Steal Chicken"), PLAYGUITAR("Play Guitar");

  private String displayValue;

  Trick(String displayValue) {
    this.displayValue = displayValue;
  }

  public String getDisplayValue() {
    return displayValue;
  }

  public static Trick getTrickFromString(String trick) {
    Trick[] tempTricks = Trick.values();
    for (Trick tempTrick : tempTricks) {
      if (tempTrick.displayValue.equalsIgnoreCase(trick)) {
        return tempTrick;
      }
    }
    return null;
  }
}