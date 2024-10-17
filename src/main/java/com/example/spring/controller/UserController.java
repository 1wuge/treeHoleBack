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

import com.example.spring.entity.Account;
import com.example.spring.service.UserService;
import com.example.spring.vo.ResultVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */

@RestController
@RequestMapping("/user")
public class UserController {



    /**
     * 已做了全局跨域配置
     * http://localhost:9080/user/login
     * 用户登录
     * @return
     */
    @RequestMapping("/login")
    public ResultVo login(String account, String password) {
        ResultVo vo = UserService.login(account, password);
        return vo;
    }

    /**
     * 注册
     * http://localhost:9090/user/register
     * @param account
     * @return
     */
    @PostMapping("/register")
    public ResultVo register(@RequestBody Account account) {
        System.out.println("Received account: " + account);
        ResultVo vo = UserService.register(account);
        return vo;
    }

    /**
     * 判断用户账号是否已注册
     * @param account
     * @return
     */
    @RequestMapping("/judge")
    public  ResultVo judge(String account){
        ResultVo vo = UserService.judgeAccount(account);
        return vo;
    }

}
