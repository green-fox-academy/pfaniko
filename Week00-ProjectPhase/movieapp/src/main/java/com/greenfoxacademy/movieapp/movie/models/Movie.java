package com.greenfoxacademy.movieapp.movie.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.Getter;

@Getter
@Entity
public class Movie {
  @Id
  private int id;
  private String title;
  @Transient
  private String overview;
}