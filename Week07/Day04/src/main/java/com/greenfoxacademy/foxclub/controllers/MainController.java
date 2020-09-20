package com.greenfoxacademy.foxclub.controllers;

import com.greenfoxacademy.foxclub.models.Drink;
import com.greenfoxacademy.foxclub.models.Food;
import com.greenfoxacademy.foxclub.models.Fox;
import com.greenfoxacademy.foxclub.services.FoxService;
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
      Fox myFox = foxService.getFox(name);
      model.addAttribute("name", name);
      model.addAttribute("myFox", myFox);
    }
    return "index";
  }

  @GetMapping("/login")
  public String renderLogin() {
    return "login";
  }

  @PostMapping("/login")
  public String loginUser(@RequestParam String name) {
    foxService.addNewFox(name);
    return "redirect:/?name=" + name;
  }

  @GetMapping("/nutritionStore")
  public String renderNutritionStore(Model model, @RequestParam (required = false) String name) {
    model.addAttribute("name", name);
    model.addAttribute("food", Food.values());
    model.addAttribute("drink", Drink.values());
    return "nutrition-store";
  }

  @PostMapping("/nutritionStore")
  public String renderNutritionStore(@RequestParam(required = false) String name, @ModelAttribute
      Food food, @ModelAttribute Drink drink) {
    Fox myFox = foxService.getFox(name);
    myFox.setDrink(drink);
    myFox.setFood(food);
    return "redirect:/?name=" + name;
  }
}