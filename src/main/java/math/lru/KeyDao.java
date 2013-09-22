package math.lru;


public class KeyDao {
	
	private KeyDao pre;
	private KeyDao next;
	
	private String value;
	
	public KeyDao(String value) {
		this.value = value;
	}

	public KeyDao getPre() {
		return pre;
	}

	public void setPre(KeyDao pre) {
		this.pre = pre;
	}

	public KeyDao getNext() {
		return next;
	}

	public void setNext(KeyDao next) {
		this.next = next;
	}

	public String getValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		return value.equals(((KeyDao)obj).value);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	

}
