package com.example.insuredopenapi.controller;

import com.example.insuredopenapi.dto.BlogDto;
import com.example.insuredopenapi.service.BlogService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BlogControllerTest {

    MockMvc mockMvc;

    @InjectMocks
    BlogController blogController;

    @Mock
    BlogService blogService;

    BlogDto blogDto;

    Gson gson = new Gson();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(blogController).build();

        blogDto = new BlogDto();
        blogDto.setTitle("Weird Interpretation");
        blogDto.setContent("Words words words");
    }

    @Test
    void addBlog() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/")
                .accept(MediaType.APPLICATION_JSON)
                .content(gson.toJson(blogDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchBlog() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchOneBlog() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}