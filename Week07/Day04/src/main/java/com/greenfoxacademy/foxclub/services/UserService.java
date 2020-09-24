package com.greenfoxacademy.foxclub.services;

import com.greenfoxacademy.foxclub.models.User;
import com.greenfoxacademy.foxclub.repositories.UserRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void addUser(User user) {
    userRepository.save(user);
  }

  public User getUser(long userId) {
    return userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
  }
}
