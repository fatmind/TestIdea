package calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalenderDemo {
	
	public static void main(String[] args) throws Exception {
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.DAY_OF_MONTH, 3);
		System.out.println(calendar.getTime());
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = "2010-10-11 12:08:09";
		System.out.println(format.parse(str)); 
	}

}
