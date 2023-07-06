package com.spring.ex02;

public class PersonServiceImpl1 implements PersonService{
	
	private String name;
	
	public PersonServiceImpl1(String name) {
		this.name = name;
	}
	
	@Override
	public void sayHello() {
		System.out.println(name + "님 안녕하세요");
	}
	
}
