package com.example.crud.payload;

import lombok.Data;

@Data
public class PostDto {
    private Long Id;
    private String title;
    private String description;
}
