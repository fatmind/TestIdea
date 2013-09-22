package generic.bound;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestMain {

	public void upperBound(List<? extends Date> list) {
		/*
		 * �޷�����
		 */
		//Date date = new Date();
		// list.add(date);

		/*
		 * �޷�����
		 */
		//Timestamp t = new Timestamp(1000);
		// list.add(t);
		
		/*
		 * ����������µ��ã���list.add(date)����
		 * List<Timestamp> list = new ArrayList<Timestamp>();
		 * upperBound(list)
		 * ��֮����δ֪���������޷���֤����ȷ�ԣ��򱨴�
		 */

		list.add(null);// �����Ա��룬��Ϊnullû��������Ϣ
	}

	/*
	 * compiler��֤���Date�����ĵ�������ȷ��
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
	 * ������ʵ����ʱ������ȷT�����ͣ������Ĳ��������Ͱ�ȫ��
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
		when(main.getDate()).thenReturn(new ArrayList<Date>()); //1.����OK
		/* 2������ʾ��3��4ͬ��
		 * The method thenReturn(List<capture#2-of ? extends Date>) in the type 
		 * OngoingStubbing<List<capture#2-of ? extends Date>> 
		 * is not applicable for the arguments (ArrayList<Date>)
		 */
//		when(main.getDateT()).thenReturn(new ArrayList<Date>()); //2.�������
//		when(main.getDateT()).thenReturn(new ArrayList<Timestamp>()); //3.�������
//		when(main.getDateT()).thenReturn(new ArrayList<Object>()); //4.�������
//		when(main.getDateT()).thenReturn(new ArrayList()); //5.����OK
	}


}
