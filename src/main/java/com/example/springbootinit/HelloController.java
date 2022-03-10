package com.example.springbootinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tom.Wang
 */
@RestController
public class HelloController {

    @Value("${name}")
    private String name;

    @Value("${person.name}")
    private String personname;

    @Value("${person.age}")
    private String personage;

    @Value("${person3.name}")
    private String person3name;

    @Value("${address[0]}")
    private String addr0;

    @Value("${address[1]}")
    private String addr1;

    @Value("${msg1}")
    private String msg1;

    @Autowired
    private Environment env;

    @Autowired
    private Person person;

    @RequestMapping("/getname")
    public String getName(){
        System.out.println(name);
        System.out.println(personname);
        System.out.println(personage);
        // 注入的方式
        System.out.println(person3name);

        // 数组
        System.out.println(addr0+"  "+addr1);

        // 纯量
        System.out.println(msg1);

        System.out.println("-----------------------------------");
        System.out.println(env.getProperty("person3.name"));
        System.out.println(env.getProperty("address[1]"));

        System.out.println("-----------------------------------");
        System.out.println(person);
        String[] address = person.getAddress();
        for (String s : address) {
            System.out.println(s);
        }
        return "控制台输出信息";
    }



    @RequestMapping("/hello")
    public String hello(){
        return "Hello SpringBoot->springbootinit";
    }
}
