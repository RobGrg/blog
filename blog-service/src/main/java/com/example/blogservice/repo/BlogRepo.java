package com.example.blogservice.repo;

import com.example.blogservice.entity.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo extends CrudRepository<Blog, Long> {

}
