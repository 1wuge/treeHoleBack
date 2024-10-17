package com.example.spring.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.spring.entity.Account;
import com.example.spring.entity.Article;
import com.example.spring.entity.Comments;

import java.util.List;


public interface AccountMapper {

    List<Account> selectAll();

    Account selectByAccountNum(String account);

    Account selectByAccount(@Param("account") String account, @Param("password") String password);

    int register(Account account);
}


