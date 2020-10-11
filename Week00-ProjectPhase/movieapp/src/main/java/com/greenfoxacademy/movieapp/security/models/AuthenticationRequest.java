package com.greenfoxacademy.movieapp.security.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
  private String username;
  private String password;

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}