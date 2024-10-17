package com.example.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    String account;
    int tid;
    int theme;
    String title;
    String content;
    String time;
    String picturePath;

}
