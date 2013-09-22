package com.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * ���Լ����壺����RunWithTest��ר��Ϊ���Լ�
 * 1.@RunWith(Suite.class)
 * 2.@SuiteClasses({A.class, B.class})������Ҫ���Ե��࣬��A��B
 * 3.���ܰ��������磺@SuiteClasses(RunWithTest.class)
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
