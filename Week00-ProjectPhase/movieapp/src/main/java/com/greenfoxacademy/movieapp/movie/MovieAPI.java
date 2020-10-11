package com.greenfoxacademy.movieapp.movie;

import com.greenfoxacademy.movieapp.movie.models.MovieList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieAPI {

  @GET("movie/top_rated")
  Call<MovieList> getMovies(@Query("api_key") String accessToken,
                            @Query("language") String language, @Query("page") int page);

  @GET("movie/popular")
  Call<MovieList> getPopularMovies(@Query("api_key") String accessToken,
                            @Query("language") String language, @Query("page") int page);
}