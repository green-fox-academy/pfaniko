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

  @GetMapping(value = "/foxclub")
  public String renderMainPage(@RequestParam(required = false) Long userId, Model model) {
    model.addAttribute("userId", userId);
    return "main";
  }

  @GetMapping("/register")
  public String renderRegisterPage(Model model) {
    model.addAttribute("user", new User());
    return "register";
  }

  @GetMapping("/login")
  public String renderLogin(@RequestParam long userId, Model model) {
    model.addAttribute("userId", userId);
    return "login";
  }

  @GetMapping(value = "/")
  public String renderWebsite(@RequestParam(required = false) String name,
                              @RequestParam long userId, Model model) {
    model.addAttribute("userId", userId);
    model.addAttribute("name", name);
    model.addAttribute("myFox", foxService.getFox(name));
    return "index";
  }

  @GetMapping("/nutritionStore")
  public String renderNutritionStore(Model model, @RequestParam(required = false) String name,
                                     @RequestParam long userId) {
    model.addAttribute("name", name);
    model.addAttribute("userId", userId);
    Fox myFox = foxService.getFox(name);
    model.addAttribute("myFox", myFox);
    model.addAttribute("allFood", Food.values());
    model.addAttribute("allDrink", Drink.values());
    return "nutrition-store";
  }

  @GetMapping("/trickCenter")
  public String renderTrickCenter(Model model, @RequestParam(required = false) String name,
                                  @RequestParam long userId) {
    model.addAttribute("userId", userId);
    model.addAttribute("name", name);
    model.addAttribute("trick", Trick.values());
    return "trick-center";
  }

  @PostMapping("register")
  public String addNewUser(@ModelAttribute User user) {
    userService.addUser(user);
    return "redirect:foxclub/?userId=" + user.getId();
  }

  @PostMapping("/login")
  public String loginUser(@RequestParam String name, @RequestParam long userId) {
    Fox myFox = new Fox(name);
    User currentUser = userService.getUser(userId);
    myFox.setUser(currentUser);
    foxService.addFox(myFox);
    return "redirect:/?userId=" + userId + "&name=" + name;
  }

  @PostMapping("/nutritionStore")
  public String addNewValueForNutrition(@RequestParam(required = false) String name,
                                        @RequestParam long userId,
                                        @ModelAttribute Fox myFox) {
    foxService.changeFox(myFox);
    return "redirect:/?userId=" + userId + "&name=" + name;
  }

  @PostMapping("/trickCenter")
  public String addNewValueForTricks(@RequestParam(required = false) String name,
                                     @RequestParam long userId,
                                     String trick) {
    Fox myFox = foxService.getFox(name);
    foxService.addTrick(myFox, Trick.getTrickFromString(trick));
    return "redirect:/?userId=" + userId + "&name=" + name;
  }
}