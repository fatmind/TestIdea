package com.property;

public class TestMain {

    /** 
     * @param args 
     * Jul 22, 2010 11:06:54 AM
     * bohan.sj 
     */
    public static void main(String[] args) throws Exception {
        
        //Parent parent1 = new Parent();
        //Parent parent2 = new Parent();
        
        //Thread.sleep(3000);
        
        SubClass1 s1 = new SubClass1();
        SubClass1 s11 = new SubClass1();
        
        SubClass2 s2 = new SubClass2();
        
        
        s1.toHashCode();
        s11.toHashCode();
        
        s2.toHashCode();
        
        //System.out.println(s1.time.hashCode()); 
        //System.out.println(s2.time.hashCode());
        
//       System.out.println(parent1.time.hashCode()); 
//       System.out.println(parent2.time.hashCode()); 
        
        //Thread.sleep(10000000);
    }

}
