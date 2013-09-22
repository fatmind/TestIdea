package com.pagebreak;

public class TestEncode {
	
	public static void main(String[] args) throws Exception {
		
//		/**
//		 * ��������֪ʶ
//		 */		
//		toHexPrint("��a", "gb2312");
//		toHexPrint("�й�", "iso8859-1");
//		toHexPrint("�й�", "utf-8");
//		toHexPrint("�й�", "utf-16");  //����ֽ��� fe ff(���),(FF FE)С��
//		
//		
		/**
		 * Ϊʲô���� ��
		 */
//		String str = "��";
//		byte[] byteGb18030 = str.getBytes("gb18030");
//		toHexPrint(byteGb18030);
//		String srcUtf8 = new String(byteGb18030, "utf-8");
//		toHexPrint(srcUtf8);
//		System.out.println(srcUtf8);
//		
//		byte[] byteIso8859 = str.getBytes("iso8859-1");
//		toHexPrint(byteIso8859);

		/**
		 * ˫��ת��
		 */
		String src = "��";
		toHexPrint(src, "utf-16"); //utf-16
		byte[] srcByteGb18030 = src.getBytes("gb18030");
		toHexPrint(srcByteGb18030); //gb18030
		String dest = new String(srcByteGb18030, "gb18030");
		System.out.println(dest);

		
		
		

		
		
		
		
		

		
	} 
	
	public static void toHexPrint(String str) throws Exception {
		byte[] bytes = str.getBytes();
		toHexPrint(bytes);
	}
	
	
	public static void toHexPrint(String str, String charset) throws Exception {
		byte[] bytes = str.getBytes(charset);
		toHexPrint(bytes);
	}
	

	
	public static void toHexPrint(char[] chars) {
		for(int i=0; i<chars.length; i++) {
			char c = chars[i];
			int cInt = c;
			System.out.println(cInt + " : " + Integer.toHexString(cInt));
		}
	}
	
	public static void toHexPrint(byte[] bytes) {
		
		for(int i=0; i<bytes.length; i++) {
			String temp = Integer.toHexString(bytes[i] & 0xFF);
			if(temp.length() == 1) {
				temp = "0" + temp;
			}
			System.out.print(temp  + " ");
		}
		System.out.println();
	}

}
