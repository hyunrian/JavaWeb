package com.spring.ex02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {
	
	public static void main(String[] args) {
		
		BeanFactory factory = 
				new XmlBeanFactory(new FileSystemResource("person2.xml"));
		PersonService service1 = 
				(PersonService)factory.getBean(
						"service1", PersonServiceImpl1.class);
		service1.sayHello();
		
		PersonService service2 = 
				(PersonService)factory.getBean(
						"service2", PersonServiceImpl2.class);
		service2.sayHello();
		
	}

}
