package com.classloader.custom;

import java.io.*;

/**
 *	加载一个类，检查此类的.class文件是否比.java文件旧，满足则重新编译加载 <br>
 *	正常情况，编译器发现已经存在.class文件，是不会重新编译.java文件
 */

public class CompilingClassLoader extends ClassLoader {
	
	/*
	 * 根据文件名读取文件，返回byte[]
	 */
	private byte[] getBytes(String filename) throws IOException {
		// Find out the length of the file
		File file = new File(filename);
		long len = file.length();

		// Create an array that's just the right size for the file's contents
		byte raw[] = new byte[(int) len];

		// Open the file
		FileInputStream fin = new FileInputStream(file);

		// Read all of it into the array; 
		// if we don't get all, then it's an error.
		int r = fin.read(raw);
		if (r != len) {
			throw new IOException("Can't read all, " + r + " != " + len);
		}

		// Don't forget to close the file!
		fin.close();
		
		return raw;
	}

	/**
	 * 编译sourceFile
	 * @param sourceFile
	 * @return boolean
	 * @throws IOException
	 */
	private boolean compile(String sourceFile) throws IOException {
		// Let the user know what's going on
		System.out.println("Compiling " + sourceFile + "...");

		// Start up the compiler
		Process p = Runtime.getRuntime().exec("javac " + sourceFile);

		// Wait for it to finish running
		try {
			p.waitFor();
		} catch (InterruptedException e) {
			System.out.println(e);
		}

		// Check the return code, in case of a compilation error
		int ret = p.exitValue();
		// Tell whether the compilation worked
		return ret == 0;
	}

	/*
	 * The heart of the ClassLoader
	 * automatically compile source as necessary when looking for class files
	 */
	@Override
	public Class loadClass(String name, boolean resolve)
			throws ClassNotFoundException {

		System.out.println("-------------------");
		
		// Our goal is to get a Class object
		Class clazz = null;

		// First, see if we've already dealt with this one
		clazz = findLoadedClass(name);

		System.out.println("findLoadedClass : " + clazz);

		// Create a pathname from the class name
		// example : java.lang.Object => java/lang/Object
		String fileStub = name.replace('.', '/');

		String sourceFilename = "D:/workspace/TestIdea/src/main/java/" + fileStub + ".java";
		String classFilename = "D:/workspace/TestIdea/target/classes/" + fileStub + ".class";

		File sourceFile = new File(sourceFilename);
		File classFile = new File(classFilename);

		System.out.println( "source modified :"+sourceFile.lastModified()+"; class modified :"+ classFile.lastModified() );

		
		if (sourceFile.exists()
				&& (!classFile.exists() || sourceFile.lastModified() > classFile.lastModified())) {

			try {
				// Try to compile it
				if (!compile(sourceFilename)) {
					throw new ClassNotFoundException("Compile failed : " + sourceFilename);
				}
			} catch (IOException ie) {
				// Another place where we might come to if we fail to compile
				throw new ClassNotFoundException(ie.toString());
			}
		}

		try {
			// read the bytes
			byte raw[] = getBytes(classFilename);
			// try to turn them into a class
			clazz = defineClass(name, raw, 0, raw.length);
			System.out.println( "defineClass : " + clazz );
		} catch (IOException e) {
			//e.printStackTrace();
			/*
			 *  This is not a failure! If we reach here, 
			 *  it might mean that we are dealing with a class in a library, 
			 *  such as java.lang.Object
			 */
		}
		
		// Maybe the class is in a library -- try loading the normal way
		if (clazz == null) {
			clazz = findSystemClass(name);
			System.out.println("findSystemClass: " + clazz);
		}
		

		// Resolve the class, if any, but only if the "resolve" flag is set to true
		if (resolve && clazz!=null)
			resolveClass(clazz);

		// If we still don't have a class, it's an error
		if (clazz == null)
			throw new ClassNotFoundException(name);

		// Otherwise, return the class
		return clazz;
	}
}
