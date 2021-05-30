package com.example.insuredopenapi.controller;

import com.example.insuredopenapi.dto.BlogDto;
import com.example.insuredopenapi.dto.ResponseDto;
import com.example.insuredopenapi.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/")
    public ResponseEntity<ResponseDto> addBlog(@RequestBody BlogDto blogDto) {
        return blogService.addBlog(blogDto);
    }

    @GetMapping("/")
    public ResponseEntity<ResponseDto> fetchBlog() {
        return blogService.fetchBlog();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> fetchOneBlog(@PathVariable long id) {
        return blogService.fetchOneBlog(id);
    }

}
