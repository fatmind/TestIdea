package spring.inject;

public class SuperDog {
	
	private String name;

	public void setName(String name) {
		this.name = name;
	}
	
	protected void printName() {
		System.out.println("name : " + name);
	}
	

}
