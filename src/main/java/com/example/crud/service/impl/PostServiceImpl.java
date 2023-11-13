package com.example.crud.service.impl;

import com.example.crud.entity.Post;
import com.example.crud.payload.PostDto;
import com.example.crud.repository.PostRepository;
import com.example.crud.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    // 엔티티에 있는 값 다 가져옴
    // List 저장공간
    public List<PostDto> getAllPost() {
        // db 필드를 가져와서 엔티티 접근, post 엔티티 참조 -> list에 담음
        List<Post> posts = postRepository.findAll();
        // stream 공부
        // stream 안에 map 사용, map으로 하나씩 바꿔줌
        return posts.stream().map((post)-> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public PostDto detailPostById(long id){
        // id값이 없을 때 예외 처리(repository)
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));

        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));

        postRepository.delete(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id){
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));

        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());

        Post savePost = postRepository.save(post);

        return modelMapper.map(savePost, PostDto.class);
    }
}
