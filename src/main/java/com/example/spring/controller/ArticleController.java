/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spring.controller;

import com.example.spring.Utils.TimeUtil;
import com.example.spring.entity.Comments;
import com.example.spring.service.ArticleService;
import com.example.spring.service.testService;
import com.example.spring.vo.ResultVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */

@RestController
@RequestMapping("/article")
public class ArticleController {

@Resource
private testService testService;

    /**
     * 已做了全局跨域配置
     * http://localhost:9080/article/add
     * 添加文章
     * @return
     */
    @RequestMapping( "/add")
    public ResultVo add(String account,String title, String content,int theme,String[] picturePathArray) {
        System.out.println(account);
        System.out.println(theme);
        System.out.println(title);
        ResultVo vo = ArticleService.add(account,title,content,theme,picturePathArray);
        return vo;
    }
    /**
     * 获取文章数量
     * http://localhost:9090/article/getnum
     * @param
     * @return
     */


    /**
     * 获取所有文章
     * http://localhost:9090/article/queryall
     * @param page,size
     * @return
     */
    @RequestMapping("/queryByFilter")
    public  ResultVo queryByFilter(int page,int size,int theme,int time,int sort){
        page=(page-1)*size;
        ResultVo vo = ArticleService.queryByFilter(page, size,theme,time,sort,false);
        return vo;
    }

    /**
     * 获取对应的文章和评论
     * http://localhost:9090/article/query
     * @param tid
     * @return
     */
    @RequestMapping("/query")
    public  ResultVo query(int tid){

        ResultVo vo = ArticleService.query(tid);
        return vo;
    }

    /**
     * 获取对应的文章和评论
     * http://localhost:9090/article/comment
     * @param account,tid,comment
     * @return
     */
    @RequestMapping("/comment")
    public  ResultVo comment(String account,int tid,String comment){
        Comments comments=new Comments();
        comments.setComment(comment);
        comments.setTid(tid);
        comments.setAccount(account);
        comments.setCtime(TimeUtil.getNowTime());
        ResultVo vo = ArticleService.addComment(comments);
        return vo;
    }

    @GetMapping("/test")
    public int Test()
    {
        testService.test();
        return 1;
    }

}
