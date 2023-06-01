package com.example1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

public class Main {
    public static void main(String[] args) {

//        序列化一个对象
        Person person = new Person("Bob", 25); // 初始化对象的时候 name在前，age在后，怎么转化成json字符串的时候就变成了age在前，name在后了？
//        原来，在fastjson中，默认情况下，生成的JSON字符串的顺序是按照属性的字母顺序进行排序的，而不是按照属性在类中的声明顺序。如果我们希望按照属性在类中的声明顺序来生成JSON字符串，可以通过在类中使用@JSONType注解来设置属性的序列化顺序
        String jsonString = JSON.toJSONString(person);
        System.out.println(jsonString);

//        反序列化一个对象
        String jsonString1 = "{\"user_age\":25,\"user_name\":\"Bob\"}";
        Person person2 = JSON.parseObject(jsonString1, Person.class);
        System.out.println(person2.getName() + ", " + person2.getAge());

    }

    @JSONType(orders = {"name", "age"})
    public static class Person {
        @JSONField(name = "user_name")
        private String name;
        @JSONField(name = "user_age")
        private int age;

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String getName(){
            return name;
        }

        public int getAge(){
            return age;
        }
    }
}
