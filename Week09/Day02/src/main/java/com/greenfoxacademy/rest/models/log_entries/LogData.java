package com.greenfoxacademy.rest.models.log_entries;

import java.util.List;

public class LogData {
  private List<Log> entries;
  private int entry_count;

  public LogData() {
  }

  public void setEntries(List<Log> entries) {
    this.entries = entries;
  }

  public void setEntry_count(int entry_count) {
    this.entry_count = entry_count;
  }

  public List<Log> getEntries() {
    return entries;
  }

  public int getEntry_count() {
    return entry_count;
  }

  public LogData(List<Log> entries, int entry_count) {
    this.entries = entries;
    this.entry_count = entry_count;
  }
}
