package com.spring.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {
	
	public static void main(String[] args) {
		
		/* 
		// 기존에 했던 방식
		PersonServiceImpl1 service1 = new PersonServiceImpl1();
		service1.setName("홍길동");
		service1.sayHello();
		*/
		
		// xml파일에 bean으로 등록해놓음. 동작 방식만 이해하면 됨
		BeanFactory factory = 
				new XmlBeanFactory(new FileSystemResource("person.xml"));
		PersonService service1 = 
				(PersonService)factory.getBean(
						"service1", PersonServiceImpl1.class);
		service1.sayHello();
		
		PersonService service2 = 
				(PersonService)factory.getBean(
						"service1", PersonServiceImpl1.class);
		service2.sayHello();
		
		// 두개가 주소값이 같음 -> 같은 객체임!
		System.out.println("service1: " + service1);
		System.out.println("service2: " + service2);
		System.out.println("----------------------");
		
		PersonService service3 = 
				(PersonService)factory.getBean(
						"service2", PersonServiceImpl2.class);
		service3.sayHello();
		
	}

}
