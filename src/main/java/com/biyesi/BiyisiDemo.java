package com.biyesi;

import java.util.HashMap;
import java.util.Set;

public class BiyisiDemo {

	private static String goodEmail = "��ã���Ҫ�ٱ�����http://shop123413414.taobao.com���õ���۵Ķ����󲿷��Ǽٻ����뾡����";

	private static String spamEmail = "������С椣����į�����ҵ�����ɣ�http://sdfds.taobao.com������ȤƷ����";

	private static HashMap<String, Integer> spamMap = new HashMap<String, Integer>();
	private static HashMap<String, Integer> goodMap = new HashMap<String, Integer>();

	private static HashMap<String, Double> probabilityRepositor = new HashMap<String, Double>();

	/**
	 * �ִʣ�������ֵ��ܴ���
	 * @param str
	 * @param relation
	 */
	private static void token(String str, HashMap<String, Integer> relation) {
		for (int i=0; i<str.length(); i++) {
			String tokenNode = str.charAt(i) + "";
			if (relation.containsKey(tokenNode)) {
				relation.put(tokenNode, relation.get(tokenNode) + 1);
			} else {
				relation.put(tokenNode, 1);
			}
		}
	}

	private static void calculate() {

		token(spamEmail, spamMap);
		token(goodEmail, goodMap);

		Set<String> spamSet = spamMap.keySet();

		double spamMapLength = spamMap.size();
		double goodMapLength = goodMap.size();

		for (String str : spamSet) {
			Integer p1 = spamMap.get(str);
			Integer p2 = goodMap.get(str);

			double pSpam = p1 / spamMapLength;

			if (p2 == null) {
				probabilityRepositor.put(str, pSpam);
			} else {
				double pTotal = p1 / spamMapLength + p2 / goodMapLength;
				probabilityRepositor.put(str, pSpam / pTotal);
			}
		}

		for (String str : goodMap.keySet()) {
			if(!probabilityRepositor.containsKey(str)) { 
				probabilityRepositor.put(str, goodMap.get(str) / goodMapLength);
			}
		}

		//��ӡ������ĸ��ʷֲ�
		for (String str : probabilityRepositor.keySet()) {
			System.out.println(str + " : " + probabilityRepositor.get(str));
		}

	}

	public static void main(String[] args) {
		calculate();
		String str = "�Ҳ���";
		double denominatorPart = 1;
		double element = 1;
		for(int i=0; i<str.length(); i++) {
			String node = str.charAt(i) + "";
			double temp; 
			if(probabilityRepositor.containsKey(node)) {
				temp = probabilityRepositor.get(node);
			} else {
				temp = 0.5;
			}
			element = element * temp;
			denominatorPart = denominatorPart * (1 - temp);
		}
		System.out.println("�����ʼ��ĸ����� ��"  + element / (element + denominatorPart));
	}

}
