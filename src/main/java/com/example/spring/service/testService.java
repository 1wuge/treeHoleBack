package com.example.spring.service;

import com.example.spring.mapper.AccountMapper;
import com.example.spring.mapper.testMapper;
import com.example.spring.service.impl.testImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class testService implements testImpl {

    @Resource
    private testMapper testMapper;
    @Override
    public void test()
    {
        System.out.println(testMapper.getNum());
    }



}
