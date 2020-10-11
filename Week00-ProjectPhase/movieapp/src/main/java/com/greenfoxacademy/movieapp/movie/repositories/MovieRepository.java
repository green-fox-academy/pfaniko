package com.greenfoxacademy.movieapp.movie.repositories;

import com.greenfoxacademy.movieapp.movie.models.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
}
