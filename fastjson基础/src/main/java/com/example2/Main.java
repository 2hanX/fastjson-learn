package com.example2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        fastjson反序列化漏洞的文章里面都提到了@type，那么它到底是什么呢？@type是fastjson中的一个特殊注解，用于标识JSON字符串中的某个属性是一个Java对象的类型。具体来说，当fastjson从JSON字符串反序列化为Java对象时，如果JSON字符串中包含@type属性，fastjson会根据该属性的值来确定反序列化后的Java对象的类型。
        String json =  "{\"@type\":\"java.lang.Runtime\",\"@type\":\"java.lang.Runtime\",\"@type\":\"java.lang.Runtime\"}";
        ParserConfig.getGlobalInstance().addAccept("java.lang");
        Runtime runtime = (Runtime) JSON.parseObject(json, Object.class);
        runtime.exec("calc.exe");
    }
}
