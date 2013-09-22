package com.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 测试集定义：空类RunWithTest，专门为测试集
 * 1.@RunWith(Suite.class)
 * 2.@SuiteClasses({A.class, B.class})包含所要测试的类，如A、B
 * 3.不能包含自身，如：@SuiteClasses(RunWithTest.class)
 * @author bohan.sj
 *
 */

@RunWith(Suite.class)
@SuiteClasses({A.class, B.class})

public class RunWithTest {
	
	@Test
	public void display() {
		System.out.println(" RunWithTest is ... "); 
	}
	
}
