package com.junit;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTest {
	
	 private String refpid;
	 
	 public ParameterizedTest(String refpid) {
	    this.refpid = refpid;
	 }
 
	 @Parameters
	 public static Collection<String[]> data() {
		 String[][] data = new String[][]{{null}, {""}, {"123"}};
		 return Arrays.asList(data);
	 }
 
	 @Test
	 public void pushTest() {
	   System.out.println("Parameterized Number is : " + this.refpid);
	 }


}
