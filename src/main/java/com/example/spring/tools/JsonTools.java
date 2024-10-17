package com.example.spring.tools;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Date 2024/6/29 17:31
 * @Author Corday
 * @Email abc@qq.com
 */
@Component
public class JsonTools {
    //1.json字符串转 java实体类对象
    //{obj:{username:tom,password:123}}
    //或{username:tom,password:123}
    public static <T> T jsonToJava(String json, Class<T> clazz) {
        //将字符串转成json对象
        JSONObject jsonObject = JSONObject.parseObject(json);
        T obj = jsonObject.getObject("obj", clazz);
        return obj;
    }

    //2.json数组字符串转java集合对象,<T>通用泛型，代表任一个实体，实现通过工具
    //[{},{},{}]
    public static <T> List<T> jsonToList(String json, Class<T> clazz) {
        //将字符串转json数组对象
        JSONArray jsonArray = JSONArray.parseArray(json);
        List<T> list = jsonArray.toJavaList(clazz);
        return list;
    }

    //3.Java对象转json字符串,Controller中添加@ResponseBody,return将自动转换
    public static <T> String javaTojson(T t) {
        String str = JSONObject.toJSONString(t);
        return str;
    }
}
