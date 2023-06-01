package com.example;

import com.alibaba.fastjson.JSON;

public class Main {
    public static void main(String[] args) {

//        序列化一个对象
        Person person = new Person("isok", 25);
        String jsonString = JSON.toJSONString(person);
        System.out.println(jsonString);

//        反序列化一个对象
        String jsonString1 = "{\"age\":25,\"name\":\"isok\"}";
        Person person1 = JSON.parseObject(jsonString1, Person.class);   // 这里为什么可以直接使用Person.class来进行映射？
        System.out.println(person1.getName() + ", " + person1.getAge());

//        在使用fastjson时，我们需要先将JSON字符串和Java对象之间建立映射关系，可以通过类的属性和JSON字段名进行映射。在我们上面的代码中，Java类的属性名和JSON字段名是相同的，因此可以直接使用Person.class来进行映射。如果不同我们该怎么办？我们可以通过使用注解来指定它们之间的映射关系。在fastjson中，可以使用@JSONField注解来指定Java类的属性和JSON字段之间的映射关系。请看com.example1代码
    }

    public static class Person {
        private String name;
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
