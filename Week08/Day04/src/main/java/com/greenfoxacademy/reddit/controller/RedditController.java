package com.greenfoxacademy.reddit.controller;

import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

  @RequestMapping("/vote-up")
  public String voteUpOnePost(@RequestParam (value = "id", required = false) int id) {
    postService.voteUpOnePost(id);
    return "redirect:/";
  }

  @RequestMapping("/vote-down")
  public String voteDownOnePost(@RequestParam (value = "id", required = false) int id) {
    postService.voteDownOnePost(id);
    return "redirect:/";
  }

  @PostMapping("/submit")
  public String addPost(Post newPost) {
    postService.addPost(newPost);
    return "redirect:/";
  }
}