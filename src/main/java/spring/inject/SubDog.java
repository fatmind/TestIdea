package spring.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SubDog extends SuperDog {
	
	public static void main(String[] args) {
		
		String configFile = "spring/inject/spring-beans.xml";
		ApplicationContext app = new ClassPathXmlApplicationContext(configFile);
		
		SubDog dog = (SubDog)app.getBean("dog");
		dog.printName();
		
	}

}
