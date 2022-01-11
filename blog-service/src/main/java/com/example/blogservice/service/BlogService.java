package com.example.blogservice.service;

import com.example.blogservice.entity.Blog;
import com.example.blogservice.exception.NotFoundException;
import com.example.blogservice.repo.BlogRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class BlogService {
    private final BlogRepo blogRepo;

    public void save(Blog blog){
        blogRepo.save(blog);
    }

    public Blog findById(Long id) throws NotFoundException {
        Optional<Blog> blogOptional = blogRepo.findById(id);
        if (blogOptional.isPresent()){
            return blogOptional.get();
        }
        throw new NotFoundException("Blog with Id was not found.");
    }
}
