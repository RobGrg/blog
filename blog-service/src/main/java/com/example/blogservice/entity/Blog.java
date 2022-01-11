package com.example.blogservice.entity;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "blog_name")
    private String blogName;

    @Column(name = "blog_content")
    private String blogContent;
}
