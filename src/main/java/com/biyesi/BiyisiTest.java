package com.biyesi;

import java.util.Hashtable;

public class BiyisiTest {

	/**
	 * 准备两个测试的文件正文 goodText为普通邮件正文 badText为垃圾邮件正文
	 */
	private final static String goodText = "你好，我要举报网店http://shop123413414.taobao.com，"
			+ "该店出售的东西大部分是假货，请尽快查封";
	private final static String badText = "哈哈，小妞，你寂寞吗？来我的网店吧：http://sdfds.taobao.com，有情趣品出售。";

	/**
	 * 普通邮件哈希表
	 */
	Hashtable<String, Integer> goodHashtable = new Hashtable<String, Integer>();
	/**
	 * 垃圾邮件哈希表
	 */
	Hashtable<String, Integer> badHashtable = new Hashtable<String, Integer>();

	/**
	 * 智能学习
	 */
	public void eLearn() {
		handleGoodMail();
		handleBadMail();
	}

	public void analysis(String newText) {
		int len = newText.length();
		float[] p = new float[len];
		// 按照贝叶斯公式计算
		for (int i = 0; i < len; i++) {
			int p1 = 0;
			int p2 = 0;
			String ch = newText.charAt(i) + "";

			if (goodHashtable.containsKey(ch)) {
				p1 = (Integer) goodHashtable.get(ch);
			}

			if (badHashtable.containsKey(ch)) {
				p2 = (Integer) badHashtable.get(ch);
			}

			if (p1 == 0 && p2 == 0) {
				p[i] = 0;
			} else {
				p[i] = (p1 + 0.0f) / (p1 + p2);
			}
			System.out.println("p[" + i + "]的值为：" + p[i]);
		}
		int psum = 0;
		int pasum = 1;
		for (int i = 0; i < p.length; i++) {
			psum += p[i];
			pasum *= (1 - p[i]);
		}
		System.out.println("psum=" + psum);
		System.out.println("pasum=" + pasum);
		float result;
		if (psum == 0 && pasum == 0) {
			result = 0;
		} else {

			result = psum / (psum + pasum);
		}

		System.out.println("该文章是垃圾邮件的概率为：" + (1 - result));
	}

	/**
	 * 对普通邮件进行分析 为了简单处理，我们按一字一词处理，暂不进行分词
	 */
	private void handleGoodMail() {
		int len = goodText.length();
		for (int i = 0; i < len; i++) {
			String ch = goodText.charAt(i) + "";
			if (goodHashtable.containsKey(ch)) {
				Integer sum = (Integer) goodHashtable.get(ch);
				goodHashtable.put(ch, sum + 1);
			} else {
				goodHashtable.put(ch, 1);
			}
		}
	}

	/**
	 * 对垃圾邮件进行分析 为了简单处理，我们按一字一词处理，暂不进行分词
	 */
	private void handleBadMail() {
		int len = badText.length();
		for (int i = 0; i < len; i++) {
			String ch = badText.charAt(i) + "";
			if (badHashtable.containsKey(ch)) {
				Integer sum = (Integer) badHashtable.get(ch);
				badHashtable.put(ch, sum + 1);
			} else {
				badHashtable.put(ch, 1);
			}
		}
	}

	public static void main(String[] args) {
		BiyisiTest beiyesi = new BiyisiTest();
		beiyesi.eLearn();
		beiyesi.analysis("淘宝是个小妞，你好");
	}

}
