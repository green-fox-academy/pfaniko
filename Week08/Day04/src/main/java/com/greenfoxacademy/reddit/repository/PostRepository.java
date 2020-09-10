package com.greenfoxacademy.reddit.repository;

import com.greenfoxacademy.reddit.model.Post;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {

  List<Post> findAll();
}
