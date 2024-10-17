package com.example.spring.mapper;

import com.example.spring.entity.Account;
import com.example.spring.entity.Article;
import com.example.spring.entity.Comments;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ArticleMapper {


    List<Article> getNum(@Param("theme") int theme,@Param("time") int time,@Param("sort") int sort);
    List<Article> getArticleAll(@Param("page") int page,@Param("size") int size);
    List<Article> getArticleByFilter(@Param("page") int page,@Param("size") int size,@Param("theme") int theme,@Param("time") int time,@Param("sort") int sort);
    int addArticle(@Param("account")String account,@Param("title")String title,@Param("content")String content,
                    @Param("time")String time,@Param("theme")int theme,@Param("picturePath")String picturePath);
    Article getArticle(int tid);
    List<Comments> getComments(int tid);

    int insertComment(Comments comments);

}
