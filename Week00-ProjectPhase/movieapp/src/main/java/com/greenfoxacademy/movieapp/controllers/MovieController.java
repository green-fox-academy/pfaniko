package com.greenfoxacademy.movieapp.controllers;

import com.greenfoxacademy.movieapp.movie.models.MovieList;
import com.greenfoxacademy.movieapp.movie.services.MovieService;
import com.greenfoxacademy.movieapp.security.models.AuthenticationRequest;
import com.greenfoxacademy.movieapp.security.models.AuthenticationResponse;
import com.greenfoxacademy.movieapp.security.services.MyUserDetailsService;
import com.greenfoxacademy.movieapp.security.util.JwtUtil;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
  @Autowired
  private MovieService movieService;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private MyUserDetailsService myUserDetailsService;

  @Autowired
  private JwtUtil jwtUtil;

  @GetMapping("/top-rated")
  public MovieList getMovies() throws IOException {
    return movieService.getMovies();
  }

  @GetMapping("/popular")
  public MovieList getPopularMovies() throws IOException {
    return movieService.getPopularMovies();
  }

  @PostMapping("/authenticate")
  public ResponseEntity<?> createAuthenticationToken(
      @RequestBody AuthenticationRequest authenticationRequest)
      throws Exception {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
              authenticationRequest.getPassword()));
    } catch (BadCredentialsException e) {
      throw new Exception("Incorrect username or password", e);
    }
    final UserDetails userDetails =
        myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
    final String jwt = jwtUtil.generateToken(userDetails);
    return ResponseEntity.ok(new AuthenticationResponse(jwt));
  }
}