package com.greenfoxacademy.foxclub.services;

import com.greenfoxacademy.foxclub.models.Fox;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FoxList {
  private List<Fox> foxes;

  public FoxList() {
    this.foxes=new ArrayList<>();
  }

  public List<Fox> getFoxes() {
    return foxes;
  }

  public void addNewFox(String name) {
    foxes.add(new Fox(name));
  }
}