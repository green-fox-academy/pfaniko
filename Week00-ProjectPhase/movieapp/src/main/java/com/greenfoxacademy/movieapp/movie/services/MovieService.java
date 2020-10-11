package com.greenfoxacademy.movieapp.movie.services;

import com.greenfoxacademy.movieapp.movie.MovieAPI;
import com.greenfoxacademy.movieapp.movie.models.Movie;
import com.greenfoxacademy.movieapp.movie.models.MovieList;
import com.greenfoxacademy.movieapp.movie.repositories.MovieRepository;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class MovieService {
  @Value("${API_KEY}")
  private String accessToken;
  @Value("${LANGUAGE}")
  private String language;
  @Value("${PAGE}")
  private int page;
  private final MovieAPI movieAPI;

  @Autowired
  private MovieRepository movieRepository;

  public MovieService() {

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    movieAPI = retrofit.create(MovieAPI.class);
  }

  public MovieList getMovies() throws IOException {
    Call<MovieList> call = movieAPI.getMovies(accessToken, language, page);
    Response<MovieList> response = call.execute();
    if (!response.isSuccessful()) {
      throw new IOException(
          (response.errorBody()) != null ? response.errorBody().string() : "Unknown error");
    }
    List<Movie> movies = response.body().getResults();
    movieRepository.saveAll(movies);
    return response.body();
  }

  public MovieList getPopularMovies() throws IOException {
    Call<MovieList> call = movieAPI.getPopularMovies(accessToken, language, page);
    Response<MovieList> response = call.execute();
    if (!response.isSuccessful()) {
      throw new IOException(
          (response.errorBody()) != null ? response.errorBody().string() : "Unknown error");
    }
    List<Movie> movies = response.body().getResults();
    movieRepository.saveAll(movies);
    return response.body();
  }
}