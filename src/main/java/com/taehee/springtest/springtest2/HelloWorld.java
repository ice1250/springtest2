package com.taehee.springtest.springtest2;

public class HelloWorld {

	String hello;

	public void setName(String name) {
		this.hello = name;
	}
	
	public String getName() {
		return hello;
	}
	
	public void sayHelloWorld() {
		System.out.println("hello : " + hello);
	}
}
