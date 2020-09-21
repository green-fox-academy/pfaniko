package com.greenfoxacademy.foxclub.services;

import com.greenfoxacademy.foxclub.models.Fox;
import com.greenfoxacademy.foxclub.models.Trick;
import com.greenfoxacademy.foxclub.repositories.FoxRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoxService {
  private final FoxRepository foxRepository;

  @Autowired
  public FoxService(FoxRepository foxRepository) {
    this.foxRepository = foxRepository;
  }

  public void addNewFox(String name) {
    foxRepository.getFoxes().add(new Fox(name));
  }

  public Fox getFox(String name) {
    return foxRepository.getFoxes().stream()
        .filter(fox1 -> fox1.getName().equals(name))
        .findFirst()
        .orElseThrow(() -> new NoSuchElementException(
            "This fox does not exists, please log in to create your own fox!"));
  }

  public void addTrick(Fox myFox, Trick trick) {
    List<Trick> tempTricks = myFox.getTricks();
    tempTricks.add(trick);
    myFox.setTricks(tempTricks);
  }
}