package com.example.insuredopenapi.service;

import com.example.insuredopenapi.dto.BlogDto;
import com.example.insuredopenapi.dto.ResponseDto;
import com.example.insuredopenapi.model.Blog;
import com.example.insuredopenapi.repository.BlogRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final ModelMapper modelMapper;
    private static final String SUCCESSFUL = "successful";

    public ResponseEntity<ResponseDto> addBlog(BlogDto blogDto) {
        var blog = modelMapper.map(blogDto, Blog.class);
        return ResponseEntity.ok(new ResponseDto("00", SUCCESSFUL, blogRepository.save(blog)));
    }

    public ResponseEntity<ResponseDto> fetchBlog() {
        return ResponseEntity.ok(new ResponseDto("00", SUCCESSFUL, blogRepository.findAll()));
    }

    public ResponseEntity<ResponseDto> fetchOneBlog(long id) {
        return ResponseEntity.ok(new ResponseDto("00", SUCCESSFUL, blogRepository.findById(id)));
    }
}
