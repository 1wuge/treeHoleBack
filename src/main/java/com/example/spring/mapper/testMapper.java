package com.example.spring.mapper;

import com.example.spring.entity.Account;
import com.example.spring.entity.Article;
import com.example.spring.entity.Comments;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface testMapper {


    List<Article> getNum();
    List<Article> getArticleAll(@Param("page") int page,@Param("size") int size);

    void addArticle(@Param("account")String account,@Param("title")String title,@Param("content")String content,
                    @Param("time")String time);

    List<Comments> getComments(@Param("tid")int tid,@Param("size") int size);

    Article getArticle(int tid);

    void insertComment(@Param("account")String account,@Param("tid") int tid,
                       @Param("comment") String comment,@Param("ctime") String ctime);
}
