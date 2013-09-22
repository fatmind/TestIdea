package com.classloader.custom;

public class Foo {
	
	static public void main(String args[]) throws Exception {
		System.out.println("Foo classloader : " + Foo.class.getClassLoader());
		System.out.println("Foo -> " + args[0] + " " + args[1]);
		new Bar(args[0], args[1]);
	}

}
