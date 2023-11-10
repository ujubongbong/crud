package com.example.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import jakarta.persistence.*;

@Getter // 접근 제한 사용 가능
@Setter // 수정
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column()
    private String title;

    @Column()
    private String description;
}
