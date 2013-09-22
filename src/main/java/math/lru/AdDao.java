package math.lru;


public class AdDao {

	private KeyDao key;
	private String content;

	
	public AdDao(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public KeyDao getKey() {
		return key;
	}

	public void setKey(KeyDao key) {
		this.key = key;
	}
	
}
