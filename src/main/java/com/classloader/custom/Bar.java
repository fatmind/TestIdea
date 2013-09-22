package com.classloader.custom;

import com.classloader.baz.Baz;


public class Bar {
	
	public Bar(String a, String b) {
		System.out.println("Bar classloader : " + Foo.class.getClassLoader());
		System.out.println("Bar --> " + a + " " + b);

		try {
			Class bazClass = Class.forName("com.classloader.baz.Baz");
			Baz baz = (Baz)bazClass.newInstance();
			baz.print(a, b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
