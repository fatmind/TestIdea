package serializable;

import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.alibaba.common.lang.io.ByteArrayInputStream;

public class ByteArrayTestMain {

	public static void main(String[] args) throws Exception {

		Dog dog = new Dog();
		dog.setName("xiaopang");
		
		ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outBuffer);
		objectOutputStream.writeObject(dog);
		System.out.println("serializable success ..."); 
		
		ByteArrayInputStream inBuffer = new ByteArrayInputStream(outBuffer.toByteArray());
		ObjectInputStream objectInputStream = new ObjectInputStream(inBuffer);
		Dog dDog = (Dog)objectInputStream.readObject();
		System.out.println(dDog.getName());
		
		
	}

}
