package generic.clazz;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/*
 * ²Î¿¼ £ºhttp://blog.csdn.net/gengv/archive/2010/01/11/5178055.aspx
 */

public class PersonManager<T> extends PeopleManager<Person> {

	public void printGenericClass() {
		ParameterizedType params = ((ParameterizedType)getClass().getGenericSuperclass());
		Type t = params.getActualTypeArguments()[0];
		System.out.println(t);
		
		 Class<T> persistentClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		 System.out.println(persistentClass);
	}

}


class PeopleManager<T> {
	
}

class Person {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}