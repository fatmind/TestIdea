package thread;


public class Dcl {
	
	    private int age;
	    
	    private static volatile Dcl instance;
	    
	    private Dcl() {
	        this.age = 5;         						// (1)
	    }
	    
	    public static Dcl getInstance() {
	        if (instance == null) {                     // (2)
	            synchronized(Dcl.class) {               // (3)
	                if (instance == null) {             // (4)
	                    instance = new Dcl();           // (5)
	                }
	            }
	        }
	        return instance;                            // (6)
	    }
	    
	    public int getAge() {
	        return this.age;                            // (7)
	    }

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    /*
	    private static class LazyHolder {
	    	  public static Dcl something = new Dcl();
	    }

    	public static Dcl getInstance() {
    	  return LazyHolder.something;
    	}
	    */

}
