package com.example.spring.mapper;

import com.example.spring.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface FileMapper {

    int AddImg(@Param("tid")int tid,@Param("img")String img);

    String[] GetImgs(@Param("tid")int tid);
}


