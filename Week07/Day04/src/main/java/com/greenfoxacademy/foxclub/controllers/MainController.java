package com.greenfoxacademy.foxclub.controllers;

import com.greenfoxacademy.foxclub.models.Drink;
import com.greenfoxacademy.foxclub.models.Food;
import com.greenfoxacademy.foxclub.models.Fox;
import com.greenfoxacademy.foxclub.models.Trick;
import com.greenfoxacademy.foxclub.services.FoxService;
import java.util.NoSuchElementException;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
  private final FoxService foxService;

  @Autowired
  public MainController(FoxService foxService) {
    this.foxService = foxService;
  }

  @GetMapping(value = "/")
  public String renderWebsite(@RequestParam(required = false) String name, Model model) {
    if (name == null) {
      model.addAttribute("myFox", new Fox("Mr. Fox"));
    } else {
      try {
        Fox myFox = foxService.getFox(name);
        model.addAttribute("name", name);
        model.addAttribute("myFox", myFox);
      } catch (NoSuchElementException e) {
        model.addAttribute("error",
            "This fox does not exists, please log in to create your own fox!");
      }
    }
    return "index";
  }

  @GetMapping("/login")
  public String renderLogin() {
    return "login";
  }

  @GetMapping("/nutritionStore")
  public String renderNutritionStore(Model model, @RequestParam(required = false) String name) {
    model.addAttribute("name", name);
    model.addAttribute("food", Food.values());
    model.addAttribute("drink", Drink.values());
    return "nutrition-store";
  }

  @GetMapping("/trickCenter")
  public String renderTrickCenter(Model model, @RequestParam(required = false) String name) {
    model.addAttribute("name", name);
    model.addAttribute("trick", Trick.values());
    return "trick-center";
  }


  @PostMapping("/login")
  public String loginUser(@RequestParam String name) {
    foxService.addNewFox(name);
    return "redirect:/?name=" + name;
  }

  @PostMapping("/nutritionStore")
  public String addNewValueForNutrition(@RequestParam(required = false) String name,
                                        @ModelAttribute
                                            Food food, @ModelAttribute Drink drink) {
    Fox myFox = foxService.getFox(name);
    myFox.setDrink(drink);
    myFox.setFood(food);
    return "redirect:/?name=" + name;
  }

  @PostMapping("/trickCenter")
  public String addNewValueForTricks(@RequestParam(required = false) String name,
                                     String trick) {
    Fox myFox = foxService.getFox(name);
    foxService.addTrick(myFox, Trick.getTrickFromString(trick));
    return "redirect:/?name=" + name;
  }
}