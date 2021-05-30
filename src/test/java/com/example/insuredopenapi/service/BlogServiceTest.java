package com.example.insuredopenapi.service;

import com.example.insuredopenapi.dto.BlogDto;
import com.example.insuredopenapi.dto.ResponseDto;
import com.example.insuredopenapi.model.Blog;
import com.example.insuredopenapi.repository.BlogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BlogServiceTest {

    @Autowired
    BlogService blogService;

    @MockBean
    BlogRepository blogRepository;

    Blog blog;
    BlogDto blogDto;

    @BeforeEach
    void init() {
        blog = new Blog();
        blog.setTitle("Weird Interpretation");
        blog.setContent("Words words words");

        blogDto = new BlogDto();
        blogDto.setTitle("Weird Interpretation");
        blogDto.setContent("Words words words");
    }

    @Test
    void addBlog() {
        Mockito.when(blogRepository.save(blog)).thenReturn(blog);
        ResponseEntity<ResponseDto> responseExpected = ResponseEntity.ok(new ResponseDto(
                "00",
                "Successful",
                null
        ));
        ResponseEntity<ResponseDto> actualResponse = blogService.addBlog(blogDto);
        assertThat(responseExpected.getBody().getCode()).isEqualTo(actualResponse.getBody().getCode());
    }

    @Test
    void fetchBlog() {
        Mockito.when(blogRepository.findAll()).thenReturn(List.of(blog));
        ResponseEntity<ResponseDto> responseExpected = ResponseEntity.ok(new ResponseDto(
                "00",
                "Successful",
                null
        ));
        ResponseEntity<ResponseDto> actualResponse = blogService.fetchBlog();
        assertThat(responseExpected.getBody().getCode()).isEqualTo(actualResponse.getBody().getCode());
    }

    @Test
    void fetchOneBlog() {
        Mockito.when(blogRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(blog));
        ResponseEntity<ResponseDto> responseExpected = ResponseEntity.ok(new ResponseDto(
                "00",
                "Successful",
                null
        ));
        ResponseEntity<ResponseDto> actualResponse = blogService.fetchOneBlog(Mockito.anyLong());
        assertThat(responseExpected.getBody().getCode()).isEqualTo(actualResponse.getBody().getCode());
    }
}