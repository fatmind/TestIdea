package spring.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringScopeMain {

	public static void main(String[] args) {
			
		ApplicationContext app = new ClassPathXmlApplicationContext("spring/scope/beans.xml");
		A a = (A)app.getBean("a");
		System.out.println(a.getB());
		System.out.println(app.getBean("b")); 
		
		a = (A)app.getBean("a");
 		System.out.println(a.getB());
 		System.out.println(app.getBean("b"));
	}

}


class A {
	private B b;
	public void setB(B b) {
		this.b = b;
	}
	public B getB() {
		return this.b;
	}
}

class B {
	public String name;
}
