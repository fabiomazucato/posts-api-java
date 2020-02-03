package com.posts.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import com.posts.api.entity.Post;
import com.posts.api.repository.PostRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api")
public class PostsController {

	@Autowired
	private PostRepository postRepository;
	private String messageSucessCreate = "Post criado com sucesso!";
	private String messageSucessVotes = "Seu voto foi registrado!";

	@GetMapping("/post")
	public ResponseEntity<List<Post>> all() {

		return ResponseEntity.ok(postRepository.findAll());
	}

	@PostMapping(path = "/post", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> create(@RequestBody Post body) {
		try {
			body.setVotes(0);
			body.setCreateDate();

			postRepository.save(body);

			return ResponseEntity.ok().body(messageSucessCreate);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível criar o Post. " + e);
		}

	}

	@PutMapping("/post/vote/{id}")
	public ResponseEntity<String> upVotes(@PathVariable String id) {
		try {
			Post post = postRepository.findById(id).get();
			Integer newVote = post.getVotes() + 1;
			post.setVotes(newVote);
			postRepository.save(post);

			return ResponseEntity.ok().body(messageSucessVotes);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível registrar seu voto. " + e);
		}
	}

}