package com.greenfoxacademy.movieapp.security.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthenticationResponse {
  private final String jwt;
}