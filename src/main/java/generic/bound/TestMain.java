package generic.bound;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestMain {

	public void upperBound(List<? extends Date> list) {
		/*
		 * 无法编译
		 */
		//Date date = new Date();
		// list.add(date);

		/*
		 * 无法编译
		 */
		//Timestamp t = new Timestamp(1000);
		// list.add(t);
		
		/*
		 * 假设存在如下调用，则list.add(date)错误
		 * List<Timestamp> list = new ArrayList<Timestamp>();
		 * upperBound(list)
		 * 总之类型未知，编译器无法保证其正确性，则报错
		 */

		list.add(null);// 这句可以编译，因为null没有类型信息
	}

	/*
	 * compiler保证其对Date函数的调用是正确的
	 */
	public List<? extends Date> upperBound() {
		/*
		 * success
		 */
		// List<Timestamp> lt = new ArrayList<Timestamp>();
		// return lt;

		/*
		 * success
		 */
		List<Date> ld = new ArrayList<Date>();
		return ld;
	}
	
	/*
	 * 当对象实例化时，是明确T的类型，后续的操作是类型安全的
	 */
	/*
	public List<T> upperBoundb(T o) {
		List<T> result = new ArrayList<T>();
		result.add(o);
		return result;
	}
	public void invokeUpperBoundb() {
		TestMain<String> mian = new TestMain<String>();
		mian.upperBoundb("hello");
	}
	*/
	
	
	public List<? extends Date> getDateT() {
		return null;
	}
	public List<Date> getDate() {
		return null;
	}
	public void mockGetDate() {
		TestMain main = mock(TestMain.class);
		when(main.getDate()).thenReturn(new ArrayList<Date>()); //1.编译OK
		/* 2错误提示，3、4同理
		 * The method thenReturn(List<capture#2-of ? extends Date>) in the type 
		 * OngoingStubbing<List<capture#2-of ? extends Date>> 
		 * is not applicable for the arguments (ArrayList<Date>)
		 */
//		when(main.getDateT()).thenReturn(new ArrayList<Date>()); //2.编译错误
//		when(main.getDateT()).thenReturn(new ArrayList<Timestamp>()); //3.编译错误
//		when(main.getDateT()).thenReturn(new ArrayList<Object>()); //4.编译错误
//		when(main.getDateT()).thenReturn(new ArrayList()); //5.编译OK
	}


}
