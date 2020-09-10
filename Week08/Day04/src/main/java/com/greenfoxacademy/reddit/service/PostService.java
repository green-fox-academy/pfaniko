package com.greenfoxacademy.reddit.service;

import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.repository.PostRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {
  private final PostRepository postRepository;

  public List<Post> getPosts() {
    return postRepository.findAll();
  }

  public void addPost(Post newPost) {
    postRepository.save(newPost);
  }
}