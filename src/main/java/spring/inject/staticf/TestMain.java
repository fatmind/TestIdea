package spring.inject.staticf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 更应去反思：DogUtil代码结构是否合理  ? <br>
 * 参考资料：<br>
 * http://planproof-fool.blogspot.com/2010/03/spring-setting-static-fields.html <br>
 * http://www.appfen.com/2012/spring-static-var.html
 * @author bohan.sj
 */
public class TestMain {

	public static void main(String[] args) {
		
		String file = "spring/inject/staticf/spring-beans.xml";
		ApplicationContext app = new ClassPathXmlApplicationContext(file);
		DogUtil dogUtil = (DogUtil)app.getBean("dogUtil");
		dogUtil.teacher();
		
	}

}
