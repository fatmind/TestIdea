package math.md5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class Md5CpuConsume {

	public static void main(String[] args) throws Exception {
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		File file = new File("D:/Temp/md5_test_data.txt");
		
		/*
		 * prepare data
		 */
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
		String data = "http://click.simba.taobao.com/cc_im?p=&s=66959914&k=249&e=k9CzTGgTuUKuWY6fVh%2FiIVldzqAK1EPUFj%2BJOjP13Jp82FKhuN2BPNrwodQg3Z5QAC7pHuFDdbr1HcOgpQBl4ZiGOlAWoxbT9wlyk2BkzV6MYAvFuXnnlwmL7vvEtaJMPycNnYQPD+XaqPKbsbdaI3N2hULnLaUxtoO5dTmux2X7IHNbsjFHJWaOyVJRZFibplVuePdd +O9t2%2Bbmt4XP%2Fv049mRWJ6Ztfp4aTnhNsNGdbyoa09Ln%2FsgASlg%3D%3D +[商城夏季大促]49元包邮no1dara夏装日韩情侣纯棉修身男士短袖T恤 + 【AK男装】周末疯狂购CCCP 1917纪念印花全棉圆领短袖T恤http://click.simba.taobao.com/cc_im?p=&s=66959914&k=249&e=k9CzTGgTuUKuWY6fVh%2FiIVldzqAK1EPUFj%2BJOjP13Jp82FKhuN2BPNrwodQg3Z5QAC7pHuFDdbr1HcOgpQBl4ZiGOlAWoxbT9wlyk2BkzV6MYAvFuXnnlwmL7vvEtaJMPycNnYQPD+XaqPKbsbdaI3N2hULnLaUxtoO5dTmux2X7IHNbsjFHJWaOyVJRZFibplVuePdd +O9t2%2Bbmt4XP%2Fv049mRWJ6Ztfp4aTnhNsNGdbyoa09Ln%2FsgASlg%3D%3D +[商城夏季大促]49元包邮no1dara夏装日韩情侣纯棉修身男士短袖T恤 + 【AK男装】周末疯狂购CCCP 1917纪念印花全棉圆领短袖T恤http://click.simba.taobao.com/cc_im?p=&s=66959";
		
		for(int i=0; i<100000; i++) {
			out.write(data);
		}
		out.close();
		

		//Thread.sleep(1000 * 60 * 1);
		//System.out.println("sleep end ...");
		
		long startTime = System.currentTimeMillis();
		String line = null;
		BufferedReader in = new BufferedReader(new FileReader(file));
		List<String> lines = new ArrayList<String>();
		while((line=in.readLine()) != null) {
			lines.add(line);
		}
		System.out.println("read file costTime = " + (System.currentTimeMillis()-startTime));
		
		
		System.out.println("start str compare");
		startTime = System.currentTimeMillis();
		for(String str : lines) {
			if(data.equals(str)) {}
		}
		System.out.println("compare str cost time = " + (System.currentTimeMillis()-startTime)); 
		
		/*
		System.out.println("start md5 compare ...");
		String expectValue = byteToHexStr(md.digest(data.getBytes()));
		startTime = System.currentTimeMillis();
		for(String str : lines) {
			String realValue = byteToHexStr(md.digest(str.getBytes()));
			if(expectValue.equals(realValue)) {}
		}
		System.out.println("md5 compare costTime = " + (System.currentTimeMillis()-startTime));
		*/
	}
	
	public static final String byteToHexStr(byte[] bArray) {
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2) {
				sb.append(0);
			}
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}
	
}
