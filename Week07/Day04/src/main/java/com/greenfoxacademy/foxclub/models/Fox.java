package com.greenfoxacademy.foxclub.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fox {
  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private long id;

  private String name;

  @ElementCollection(fetch = FetchType.EAGER)
  private List<Trick> tricks;

  private Food food;
  private Drink drink;

  public Fox() {
  }

  public Fox(String name) {
    this.name = name;
    this.tricks = new ArrayList<>();
    this.food = Food.Bread;
    this.drink = Drink.Water;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Trick> getTricks() {
    return tricks;
  }

  public void setTricks(List<Trick> tricks) {
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

  public void setId(long id) {
    this.id = id;
  }
}