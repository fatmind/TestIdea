package generic;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("generic/applicationContext.xml");
		
		@SuppressWarnings("unchecked")
        ResParse<Dog> parse = (ResParse<Dog>)context.getBean("parse");
		
		//ParseService<Dog> service = new ParseService<Dog>(parse);
		//List<Dog> res = service.getResult();
		
		List<Dog> res = parse.parse();
		System.out.println(res);
		
	}

}
