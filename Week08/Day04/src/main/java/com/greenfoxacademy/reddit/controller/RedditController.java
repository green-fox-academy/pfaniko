package com.greenfoxacademy.reddit.controller;

import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

  @GetMapping("/submit")
  public String renderSubmitPage(Model model) {
    model.addAttribute("newPost", new Post());
    return "submit";
  }

  @PostMapping("/submit")
  public String addPost(Post newPost) {
    postService.addPost(newPost);
    return "redirect:/";
  }
}
