package com.greenfoxacademy.webshop.controllers;

import com.greenfoxacademy.webshop.models.ShopItem;
import java.util.ArrayList;
import java.util.Comparator;
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
    return "webshop";
  }

  @GetMapping("/cheapest-first")
  public String sortCheapestFirst(Model model) {
    List<ShopItem> sortedShopItems = shopItems.stream()
        .sorted((shopItem1, shopItem2) -> (int) (shopItem1.getPrice() - shopItem2.getPrice()))
        .collect(Collectors.toList());
    model.addAttribute("shopItems", sortedShopItems);
    return "webshop";
  }

  @GetMapping("/contains-nike")
  public String filterByBrand(Model model) {
    String brand = "Nike";
    List<ShopItem> filteredByBrand = shopItems.stream()
        .filter(shopItem -> shopItem.getDescription().contains(brand) ||
            shopItem.getName().contains(brand))
        .collect(Collectors.toList());
    model.addAttribute("shopItems", filteredByBrand);
    return "webshop";
  }

  @GetMapping("/average-stock")
  public String averageStock(Model model) {
    double averageStock = shopItems.stream()
        .mapToInt(ShopItem::getQuantityOfStock)
        .average()
        .orElse(-1);
    model.addAttribute("averageStock", averageStock);
    return "averagestock";
  }

  @GetMapping("/most-expensive")
  public String getMostExpensive(Model model) {
    ShopItem mostExpensive = shopItems.stream()
        .max(Comparator.comparingDouble(ShopItem::getPrice))
        .get();
    model.addAttribute("shopItems", mostExpensive);
    return "webshop";
  }
}