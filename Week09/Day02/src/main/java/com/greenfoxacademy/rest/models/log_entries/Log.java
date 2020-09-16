package com.greenfoxacademy.rest.models.log_entries;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Log {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @JsonIgnore
  private Date createdAt;
  private String endpoint;
  private String data;

  public Log(String endpoint, String data) {
    this.createdAt = new Date();
    this.endpoint = endpoint;
    this.data = data;
  }

  public Log() {
  }

  public int getId() {
    return id;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public String getData() {
    return data;
  }
}
