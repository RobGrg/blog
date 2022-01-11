package com.example.blogservice.controller;

import com.example.blogservice.entity.Blog;
import com.example.blogservice.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.DenyAll;
import javax.validation.Valid;

@RestController
@RequestMapping("/blog")
@AllArgsConstructor
public class BlogController {
    private final BlogService blogService;
    @PostMapping("/add")
    ResponseEntity<?> add(@RequestBody @Valid Blog blog){
        blogService.save(blog);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
    }

}
