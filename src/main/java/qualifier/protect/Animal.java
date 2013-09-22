package qualifier.protect;

public abstract class Animal {

	protected abstract void printName();
	
	protected String superName() {
		return "Test";
	}
	
	private String sys() {
		return "Hello";
	}
	
}
