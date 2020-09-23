package com.greenfoxacademy.foxclub.controllers;

import com.greenfoxacademy.foxclub.models.Drink;
import com.greenfoxacademy.foxclub.models.Food;
import com.greenfoxacademy.foxclub.models.Fox;
import com.greenfoxacademy.foxclub.models.Trick;
import com.greenfoxacademy.foxclub.models.User;
import com.greenfoxacademy.foxclub.services.FoxService;
import com.greenfoxacademy.foxclub.services.UserService;
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
  private final UserService userService;

  @Autowired
  public MainController(FoxService foxService, UserService userService) {
    this.foxService = foxService;
    this.userService = userService;
  }

  @GetMapping(value ="/foxclub")
  public String renderMainPage() {
    return "main";
  }

  @GetMapping(value = "/")
  public String renderWebsite(@RequestParam(required = false) String name, Model model) {
    model.addAttribute("name", name);
    model.addAttribute("myFox", foxService.getFox(name));
    return "index";
  }

  @GetMapping("/login")
  public String renderLogin() {
    return "login";
  }

  @GetMapping("/nutritionStore")
  public String renderNutritionStore(Model model, @RequestParam(required = false) String name) {
    model.addAttribute("name", name);
    Fox myFox = foxService.getFox(name);
    model.addAttribute("myFox", myFox);
    model.addAttribute("allFood", Food.values());
    model.addAttribute("allDrink", Drink.values());
    return "nutrition-store";
  }

  @GetMapping("/trickCenter")
  public String renderTrickCenter(Model model, @RequestParam(required = false) String name) {
    model.addAttribute("name", name);
    model.addAttribute("trick", Trick.values());
    return "trick-center";
  }

  @GetMapping("/register")
  public String renderRegisterPage(Model model) {
    model.addAttribute("user", new User());
    return "register";
  }

  @PostMapping("/login")
  public String loginUser(@RequestParam String name) {
    Fox myFox = new Fox(name);
    foxService.addFox(myFox);
    return "redirect:/?name=" + name;
  }

  @PostMapping("/nutritionStore")
  public String addNewValueForNutrition(@RequestParam(required = false) String name,
                                        @ModelAttribute Fox myFox) {
    foxService.changeFox(myFox);
    return "redirect:/?name=" + name;
  }

  @PostMapping("/trickCenter")
  public String addNewValueForTricks(@RequestParam(required = false) String name,
                                     String trick) {
    Fox myFox = foxService.getFox(name);
    foxService.addTrick(myFox, Trick.getTrickFromString(trick));
    return "redirect:/?name=" + name;
  }

  @PostMapping("register")
  public String addNewUser(@ModelAttribute User user) {
    userService.addUser(user);
    return "redirect:foxclub/?user=" + user.getUsername();
  }
}