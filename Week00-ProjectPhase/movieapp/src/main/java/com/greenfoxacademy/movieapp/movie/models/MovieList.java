package com.greenfoxacademy.movieapp.movie.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Getter;

@Getter
public class MovieList {
  private int page;
  @SerializedName("total_results")
  private int totalResults;
  @SerializedName("total_pages")
  private int totalPages;
  private List<Movie> results;
}