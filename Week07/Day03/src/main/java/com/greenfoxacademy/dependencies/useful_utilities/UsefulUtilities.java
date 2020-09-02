package com.greenfoxacademy.dependencies.useful_utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsefulUtilities {
  private UtilityService utilityService;

  @Autowired
  UsefulUtilities(UtilityService utilityService) {
    this.utilityService = utilityService;
  }

  @GetMapping("/useful")
  public String mainUseful() {
    return "utility";
  }

  @GetMapping("/useful/colored")
  public String colorBackground(Model model) {
    model.addAttribute("color", utilityService.randomColor());
    return "colored";
  }
}