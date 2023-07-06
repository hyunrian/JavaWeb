package com.spring.ex01;

public class PersonServiceImpl2 implements PersonService{
	
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void sayHello() {
//		System.out.println(name + "님 안녕하세요 - " + age + "살");
		System.out.printf("%s님 안녕하세요 - %d살", name, age); // string, decimal
	}
	
	
	
	
}
