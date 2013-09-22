package hash;

import java.util.ArrayList;
import java.util.List;

public class IbatisCacheKeyTest {
	
	  private static final int DEFAULT_MULTIPLYER = 37;
	  private static final int DEFAULT_HASHCODE = 17;

	  private int multiplier;
	  private int hashcode;
	  private long checksum;
	  private int count;
	  
	  private List paramList = new ArrayList();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IbatisCacheKeyTest demo = new IbatisCacheKeyTest();
		for(int i=0; i<3; i++) {
			System.out.println(demo.update(new String("xiaopang" + i))); 
		}

	}

	public int update(Object object) {
		int baseHashCode = object.hashCode();

		count++;
		checksum += baseHashCode;
		baseHashCode *= count;

		hashcode = multiplier * hashcode + baseHashCode;

		paramList.add(object);

		return hashcode;
	}

}
