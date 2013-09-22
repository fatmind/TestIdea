package generic;

import java.util.List;

public class ParseService<T> {
	
	private ResParse<T> parse;
	
	public ParseService(ResParse<T> parse) {
		this.parse = parse;
	}
	
	public List<T> getResult() throws Exception {
		return parse.parse();
	}
	
	

}
