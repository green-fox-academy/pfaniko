package com.greenfoxacademy.foxclub.models;

import java.util.List;

public class Fox {
  private String name;
  private List<String> tricks;
  private Food food;
  private Drink drink;

  public Fox(String name) {
    this.name = name;
    this.tricks = null;
    this.food = Food.Bread;
    this.drink = Drink.Water;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getTricks() {
    return tricks;
  }

  public void setTricks(List<String> tricks) {
    this.tricks = tricks;
  }

  public Food getFood() {
    return food;
  }

  public void setFood(Food food) {
    this.food = food;
  }

  public Drink getDrink() {
    return drink;
  }

  public void setDrink(Drink drink) {
    this.drink = drink;
  }

  public Boolean hasZeroTricks(){
    return this.getTricks() == null;
  }
}