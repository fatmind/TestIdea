package generic;

import java.util.ArrayList;
import java.util.List;

public class ResParse<T> {
	
	private Class<T> clazz;
	
	public List<T> parse() throws Exception {
		List<T> res = new ArrayList<T>();
		T instance = clazz.newInstance();
		res.add(instance);		
		return res;
	}

	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	
	
	
}
