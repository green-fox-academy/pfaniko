package com.greenfoxacademy.todosql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String title;
  private boolean urgent;
  private boolean done;

  public Todo() {
  }

  public Todo(String title) {
    this.title = title;
    this.urgent = false;
    this.done = false;
  }

  public Todo(String title, boolean urgent, boolean done) {
    this.title = title;
    this.urgent = urgent;
    this.done = done;
  }

  @ManyToOne
  private Assignee assignee;

  public Todo(String title, boolean urgent, boolean done,
              Assignee assignee) {
    this.title = title;
    this.urgent = urgent;
    this.done = done;
    this.assignee = assignee;
  }

  public String getTitle() {
    return title;
  }

  public long getId() {
    return id;
  }

  public Boolean isUrgent() {
    return urgent;
  }

  public Boolean isDone() {
    return done;
  }

  public Assignee getAssignee() {
    return assignee;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setUrgent(boolean urgent) {
    this.urgent = urgent;
  }

  public void setDone(boolean done) {
    this.done = done;
  }
}