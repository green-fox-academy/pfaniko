package com.greenfoxacademy.foxclub.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long id;

  private String username;
  private String password;

  @OneToMany (mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Fox> foxes = new ArrayList<Fox>();

  public long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public List<Fox> getFoxes() {
    return foxes;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setFoxes(List<Fox> foxes) {
    this.foxes = foxes;
  }
}