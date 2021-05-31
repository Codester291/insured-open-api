package com.example.insuredopenapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blog_generator")
    @SequenceGenerator(name="blog_generator", sequenceName = "blog_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    private String title;
    private String content;
}
