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

  public void addFox(Fox myFox) {
    foxRepository.save(myFox);
  }

  public Fox getFox(String name) {
    return foxRepository.findByName(name);
  }

  public void addTrick(Fox myFox, Trick trick) {
    List<Trick> tempTricks = myFox.getTricks();
    tempTricks.add(trick);
    myFox.setTricks(tempTricks);
    foxRepository.save(myFox);
  }

  public void changeFox(Fox myFox) {
    Fox foxToUpdate =
        foxRepository.findById(myFox.getId()).orElseThrow(NoSuchElementException::new);
    foxToUpdate.setFood(myFox.getFood());
    foxToUpdate.setDrink(myFox.getDrink());
    foxRepository.save(foxToUpdate);
  }
}