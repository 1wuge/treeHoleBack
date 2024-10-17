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
import com.example.spring.service.FileService;
import com.example.spring.service.UserService;
import com.example.spring.vo.ResultVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */

@RestController
@RequestMapping("/files")
public class FileController {

    /**
     * 已做了全局跨域配置
     * http://localhost:9080/file/upload
     * 用户登录
     * @return
     */
    @RequestMapping("/upload")
    public ResultVo login(MultipartFile file) throws IOException {
        ResultVo vo = FileService.UploadImg(file);
        return vo;
    }


}
