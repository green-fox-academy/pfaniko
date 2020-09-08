package com.greenfoxacademy.todosql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String title;
  private Boolean urgent;
  private Boolean done;

  public Todo() {
  }

  public Todo(String title) {
    this.title = title;
    this.urgent=false;
    this.done=false;
  }

  public Todo(String title, Boolean urgent, Boolean done) {
    this.title = title;
    this.urgent = urgent;
    this.done = done;
  }

  public String getTitle() {
    return title;
  }

  public long getId() {
    return id;
  }

  public Boolean getUrgent() {
    return urgent;
  }

  public Boolean getDone() {
    return done;
  }
}