package com.spring.ex02;

public class PersonServiceImpl2 implements PersonService{
	
	private String name;
	private int age;
	
	public PersonServiceImpl2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public void sayHello() {
//		System.out.println(name + "님 안녕하세요 - " + age + "살");
		System.out.printf("%s님 안녕하세요 - %d살", name, age); // string, decimal
	}
	
	
	
	
}
