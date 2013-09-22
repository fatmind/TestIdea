package qualifier.protect;

public class Dog extends Animal {
	
	private String name;
	
	protected String getName() {
		return this.name;
	}

	@Override
	protected void printName() {
		System.out.println(superName());
		//super.sys();
	}
	
	

}
