package com.taehee.springtest.springtest2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
    	
    	HelloWorld hw = (HelloWorld) context.getBean("hello");
    	hw.sayHelloWorld();
    }
}
