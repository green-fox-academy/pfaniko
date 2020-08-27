package com.greenfoxacademy.webshop.controllers;

import com.greenfoxacademy.webshop.models.ShopItem;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebShopController {
  List<ShopItem> shopItems = new ArrayList<>();

  public WebShopController() {
    shopItems
        .add(new ShopItem("Running shoes", "Nike running shoes for everyday sport", 1000.0, 5));
    shopItems.add(new ShopItem("Printer", "Some HP printer that will print pages", 3000.0, 2));
    shopItems.add(new ShopItem("Coca cola", "0.5l standard coke", 25.0, 0));
    shopItems.add(new ShopItem("Wokin", "Chicken with fired rice and WOKIN sauce", 119.0, 100));
    shopItems.add(new ShopItem("T-shirt", "Blue with a corgi on a bike", 300.0, 1));
  }

  @GetMapping("/webshop")
  public String getWebshop(Model model) {
    model.addAttribute("shopItems", shopItems);
    return "webshop";
  }

  @GetMapping("/only-available")
  public String getOnlyAvailable(Model model) {
   List<ShopItem> filteredShopItems = shopItems.stream()
        .filter(shopItem -> shopItem.getQuantityOfStock() != 0)
        .collect(Collectors.toList());
    model.addAttribute("shopItems", filteredShopItems);
    return "/webshop";
  }
}