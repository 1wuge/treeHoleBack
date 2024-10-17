package com.example.spring.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
/**
 * 创建一个通用前后端分离的结果类
 * 实现返回给前端的，包括三个成员：code,object,message
 * 或：success,object,message
 * 其实也是一种实体类
 */
@Data
@Builder
@AllArgsConstructor
public class ResultVo {
    //响应码:1000查询成功,1001查询失败
    //2000添加成功,2001添加失败...
    private int code;
    //User,List<user>,Product,List<Product>
    //真实数据,要到前端去渲染
    private Object data;
    //消息提示：成功，失败
    private String message;
    //封装有两个参数的构造
    public ResultVo(int code,String message){
        this.code=code;
        this.message=message;
    }

}
