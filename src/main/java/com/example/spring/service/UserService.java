package com.example.spring.service;

import com.example.spring.Utils.SqlSessionFactoryUtils;
import com.example.spring.entity.Account;
import com.example.spring.mapper.AccountMapper;
import com.example.spring.myconst.UserConst;
import com.example.spring.vo.ResultVo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static AccountMapper accountMapper;

    static {
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
        // 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        accountMapper = sqlSession.getMapper(AccountMapper.class);
    }//给mapper赋值

    public static ResultVo login(String account, String password) {
        Account Account = accountMapper.selectByAccount(account,password);
        ResultVo rs = null;
        if (Account != null) {//code,data,message
            rs = new ResultVo(UserConst.CODEOK, Account,UserConst.USERLOGIN);
        } else {
            rs = new ResultVo(UserConst.CODENO, null, UserConst.USERERROR);
        }
        //返回vo
        return rs;
    }


    public static ResultVo register(Account account) {
        int n = 0;
        //返回用户
        Account temp = accountMapper.selectByAccountNum(account.getAccount());
        if (temp == null) {//用户不存执行添加
            n = accountMapper.register(account);
            if (n <= 0) {
                return new ResultVo(UserConst.CODENO, null, UserConst.REGNO);
            } else {
                return new ResultVo(UserConst.CODEOK, null, UserConst.REGOK);
            }
        }
        //用户名已存返回值
        return new ResultVo(UserConst.CODENO, null, UserConst.USEREXISTS);
    }
    public static ResultVo judgeAccount(String account) {
        //判断结果
        Account temp = accountMapper.selectByAccountNum(account);
        if(temp==null){//用户名不存在,前端可以注册
            return new ResultVo(UserConst.CODEOK,null,UserConst.USERNOTEXISTS);
        }
        return new ResultVo(UserConst.CODENO,null,UserConst.USEREXISTS);
    }
}
