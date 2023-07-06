package com.spring.ex01;

public class PersonServiceImpl1 implements PersonService{
	
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void sayHello() {
		System.out.println(name + "님 안녕하세요");
	}
	
	
	
	
}
