package com.example3;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class Main {
    public static void main(String[] args) {
        Person user = new Person("isok", 22);
        String s1 = JSON.toJSONString(user, SerializerFeature.WriteClassName); // 在和前面代码做对比后，可以发现其实就是在调用toJSONString方法的时候，参数里面多了一个SerializerFeature.WriteClassName方法。传入SerializerFeature.WriteClassName可以使得Fastjson支持自省，开启自省后序列化成JSON的数据就会多一个@type，这个是代表对象类型的JSON文本。FastJson的漏洞就是他的这一个功能去产生的
        String s2 = JSON.toJSONString(user);
        System.out.println(s1);
        System.out.println(s2);

//        第1种方式反序列化数据
        String str1 = JSON.toJSONString(user, SerializerFeature.WriteClassName);
        JSONObject jsonObject = (JSONObject) JSON.parse(str1);
        System.out.println(jsonObject);

//        第2种方式反序列化数据
        String str2 = JSON.toJSONString(user);
        Person user2 = JSON.parseObject(str2, Person.class);
        System.out.println(user2);

//        第3种方式反序列化数据
        String str3 = JSON.toJSONString(user, SerializerFeature.WriteClassName);
        Person user3 = JSON.parseObject(str3, Person.class);
        System.out.println(user3);

    }
}
