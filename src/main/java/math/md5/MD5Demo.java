package math.md5;

import java.security.MessageDigest;

public class MD5Demo {

	public static void main(String[] args) throws Exception {

		MessageDigest md = MessageDigest.getInstance("MD5");
		String res = byteToHexStr(md.digest("helloworld".getBytes()));
		System.out.println(res);
		
		res = byteToHexStr(md.digest("helloworld".getBytes()));
		System.out.println(res);

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
