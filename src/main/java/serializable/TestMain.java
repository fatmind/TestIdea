package serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestMain {

	
	public static void main(String[] args) throws Exception {
		
		String fileName = "src/main/java/serializable/dog.txt";
		
		/*
		 * 先执行此部分
		 */
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
		Dog dog = new Dog();
		dog.setName("xiaopang");
		NoSerializableObj noSerializableObj = new NoSerializableObj();
		noSerializableObj.setVersion("1.0");
		dog.setNoSerializableObj(noSerializableObj);
		oos.writeObject(dog);
		oos.close();
		
		/*
		 * 再执行此部分
		 */
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
//		Dog dogNew = (Dog)ois.readObject();
//		System.out.println(dogNew.getName());
//		System.out.println(dogNew.getAge());
//		ois.close();
		
	}

}
