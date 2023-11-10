package com.example.crud.service.impl;

import com.example.crud.entity.Post;
import com.example.crud.payload.PostDto;
import com.example.crud.repository.PostRepository;
import com.example.crud.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper){
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto){
        Post post = modelMapper.map(postDto, Post.class);
        Post savePost = postRepository.save(post);

        return modelMapper.map(savePost, PostDto.class);
    }
}
