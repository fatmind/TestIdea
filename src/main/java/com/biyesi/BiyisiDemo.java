package com.biyesi;

import java.util.HashMap;
import java.util.Set;

public class BiyisiDemo {

	private static String goodEmail = "你好，我要举报网店http://shop123413414.taobao.com，该店出售的东西大部分是假货，请尽快查封";

	private static String spamEmail = "哈哈，小妞，你寂寞吗？来我的网店吧：http://sdfds.taobao.com，有情趣品出售";

	private static HashMap<String, Integer> spamMap = new HashMap<String, Integer>();
	private static HashMap<String, Integer> goodMap = new HashMap<String, Integer>();

	private static HashMap<String, Double> probabilityRepositor = new HashMap<String, Double>();

	/**
	 * 分词，计算出现的总次数
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

		//打印样本库的概率分布
		for (String str : probabilityRepositor.keySet()) {
			System.out.println(str + " : " + probabilityRepositor.get(str));
		}

	}

	public static void main(String[] args) {
		calculate();
		String str = "我操你";
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
		System.out.println("垃圾邮件的概率是 ："  + element / (element + denominatorPart));
	}

}
