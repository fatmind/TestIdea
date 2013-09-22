package serializable;

import java.io.Serializable;

public class Dog implements Serializable {
	
	/*
	 * 若此version不同，则反序列化失败.
	 * serializable.Dog; local class incompatible: stream classdesc serialVersionUID = 1, local class serialVersionUID = 2.
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private NoSerializableObj noSerializableObj;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public NoSerializableObj getNoSerializableObj() {
    	return noSerializableObj;
    }
	public void setNoSerializableObj(NoSerializableObj noSerializableObj) {
    	this.noSerializableObj = noSerializableObj;
    }
	
//	private int age;
//	
//	public int getAge() {
//    	return age;
//    }
//	public void setAge(int age) {
//    	this.age = age;
//    }
	
	

}
