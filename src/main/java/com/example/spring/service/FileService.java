package com.example.spring.service;

import com.example.spring.Utils.SqlSessionFactoryUtils;
import com.example.spring.Utils.UploadUtil;
import com.example.spring.entity.Account;
import com.example.spring.mapper.AccountMapper;
import com.example.spring.mapper.FileMapper;
import com.example.spring.myconst.FileConst;
import com.example.spring.myconst.UserConst;
import com.example.spring.vo.ResultVo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {
    private static FileMapper fileMapper;

    static {
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
        // 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        fileMapper = sqlSession.getMapper(FileMapper.class);
    }//给mapper赋值

    public static ResultVo UploadImg(MultipartFile file) throws IOException {

        ResultVo rs = null;
        if (file != null) {
            rs = new ResultVo(FileConst.CODEOK, UploadUtil.uploadImage(file),FileConst.UPLOADOK);
        } else {
            rs = new ResultVo(FileConst.CODENO, null, FileConst.UPLOADNULL);
        }
        //返回vo
        return rs;
    }

}
