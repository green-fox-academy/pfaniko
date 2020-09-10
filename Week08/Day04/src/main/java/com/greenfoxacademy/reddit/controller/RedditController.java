package com.greenfoxacademy.reddit.controller;

import com.greenfoxacademy.reddit.repository.PostRepository;
import com.greenfoxacademy.reddit.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class RedditController {

  private final PostService postService;

  @RequestMapping("/")
  public String renderMainPage(Model model) {
    model.addAttribute("posts", postService.getPosts());
    return "index";
  }

  @RequestMapping("/submit")
  public String renderSubmitPage() {
    return "submit";
  }
}
