package com.example.spring.service;

import com.example.spring.Utils.SqlSessionFactoryUtils;
import com.example.spring.Utils.TimeUtil;
import com.example.spring.entity.*;
import com.example.spring.mapper.AccountMapper;
import com.example.spring.mapper.ArticleMapper;
import com.example.spring.mapper.FileMapper;
import com.example.spring.myconst.ArticleConst;
import com.example.spring.myconst.UserConst;
import com.example.spring.vo.ResultVo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private static ArticleMapper articleMapper;
    static {
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
        // 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        articleMapper = sqlSession.getMapper(ArticleMapper.class);
    }//给mapper赋值
    private static FileMapper fileMapper;

    static {
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
        // 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        fileMapper = sqlSession.getMapper(FileMapper.class);
    }//给mapper赋值



    public static ResultVo add(String account,String title,String content,int theme,String[] picturePathArray)
    {
        int judge=0;
        int tid=articleMapper.getNum(0,0,0).size();
        if(picturePathArray!=null)
        {
            judge=articleMapper.addArticle(account,title,content, TimeUtil.getNowTime(),theme,picturePathArray[0]);
            for(int i=1;i< picturePathArray.length;i++)
            {
                fileMapper.AddImg(tid+1,picturePathArray[i]);
            }
        }
        else{
            judge=articleMapper.addArticle(account,title,content, TimeUtil.getNowTime(),theme,null);
        }

       if(judge<=0)
       {
           return new ResultVo(ArticleConst.CODENO,null,ArticleConst.ADDARTINO);
       }
       else{
           return new ResultVo(ArticleConst.CODEOK,null,ArticleConst.ADDARTIOK);
       }
    }

    public static ResultVo queryall(int page,int size)
    {
        List<Article> articles=articleMapper.getArticleAll(page,size);
        if(articles.size()<=0)
        {
            return new ResultVo(ArticleConst.CODENO,null,ArticleConst.GETARTNO);
        }
        return new ResultVo(ArticleConst.CODEOK,articles,ArticleConst.GETARTOK);
    }
    public static ResultVo queryByFilter(int page,int size,int theme,int time,int sort,boolean all)
    {

        if(time==0||time==1||time==2)
        {
            time-=1;
        }
        else if(time==3)
        {
            time=6;
        } else if (time==4) {
            time=29;
        }
        List<Article> articles=articleMapper.getArticleByFilter(page, size, theme, time, sort);
        ArticlesWithNum an=new ArticlesWithNum(articles,articleMapper.getNum(theme, time, sort).size());
        if(articles.size()<=0)
        {
            return new ResultVo(ArticleConst.CODEOK,null,ArticleConst.GETARTOK);
        }
        return new ResultVo(ArticleConst.CODEOK,an,ArticleConst.GETARTOK);
    }
    public static ResultVo query(int tid)
    {

        Article ar=articleMapper.getArticle(tid);

        ArticleWithComments ac=new ArticleWithComments(ar.getAccount(), ar.getTid(),ar.getTheme(),ar.getTitle(),
                ar.getContent(),ar.getTime(),fileMapper.GetImgs(tid),articleMapper.getComments(tid));
        System.out.println(articleMapper.getComments(tid));
        if(ar==null)
        {
            return new ResultVo(ArticleConst.CODENO,null,ArticleConst.GETARTNO);
        }
        else{
            return new ResultVo(ArticleConst.CODEOK,ac,ArticleConst.GETARTOK);
        }
    }

    public static ResultVo addComment(Comments comments)
    {
        int n=articleMapper.insertComment(comments);
        if(n<=0)
        {
            return new ResultVo(ArticleConst.CODENO,null,ArticleConst.ADDCOMMENTNO);
        }
        return  new ResultVo(ArticleConst.CODEOK,null,ArticleConst.ADDCOMMENTOK);
    }

}
