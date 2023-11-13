package com.example.crud.controller;

import com.example.crud.payload.PostDto;
import com.example.crud.service.PostService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private PostService postService;
    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> getAllPost(){
        return ResponseEntity.ok(postService.getAllPost());
    }
}
