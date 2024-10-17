package com.example.spring.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleWithComments {
    String account;
    int tid;
    int theme;
    String title;
    String content;
    String time;
    String[] picturePaths;
    List<Comments> comments;

}
