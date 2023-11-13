package com.example.crud.service;

import com.example.crud.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPost();

    // 변수 지정
    // long nullX
    PostDto detailPostById(long id);
}
