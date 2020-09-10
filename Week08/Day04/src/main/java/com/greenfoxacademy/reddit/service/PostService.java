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

  public void voteUpOnePost(int id) {
    Post selectedPost = postRepository.findById(id).get();
    selectedPost.setVotes(selectedPost.getVotes()+ 1);
    postRepository.save(selectedPost);
  }

  public void voteDownOnePost(int id) {
    Post selectedPost = postRepository.findById(id).get();
    selectedPost.setVotes(selectedPost.getVotes()- 1);
    postRepository.save(selectedPost);
  }
}