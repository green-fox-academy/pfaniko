package com.greenfoxacademy.dependencies.useful_utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
  public String setColoredBackground(Model model) {
    model.addAttribute("color", utilityService.randomColor());
    return "colored";
  }

  @GetMapping("/useful/email")
  public String validateEmail (Model model, @RequestParam (required = false) String email) {
    model.addAttribute("email", email);
    model.addAttribute("validatedEmail", utilityService.validateEmail(email));
    return "email";
  }

  @GetMapping("/useful/encode")
  public String encodeText (Model model, @RequestParam (required = false) String text, @RequestParam int number) {
    model.addAttribute("encodedText", utilityService.caesar(text, number));
    return "encode";
  }
}