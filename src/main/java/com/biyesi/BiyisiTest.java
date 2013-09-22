package com.biyesi;

import java.util.Hashtable;

public class BiyisiTest {

	/**
	 * ׼���������Ե��ļ����� goodTextΪ��ͨ�ʼ����� badTextΪ�����ʼ�����
	 */
	private final static String goodText = "��ã���Ҫ�ٱ�����http://shop123413414.taobao.com��"
			+ "�õ���۵Ķ����󲿷��Ǽٻ����뾡����";
	private final static String badText = "������С椣����į�����ҵ�����ɣ�http://sdfds.taobao.com������ȤƷ���ۡ�";

	/**
	 * ��ͨ�ʼ���ϣ��
	 */
	Hashtable<String, Integer> goodHashtable = new Hashtable<String, Integer>();
	/**
	 * �����ʼ���ϣ��
	 */
	Hashtable<String, Integer> badHashtable = new Hashtable<String, Integer>();

	/**
	 * ����ѧϰ
	 */
	public void eLearn() {
		handleGoodMail();
		handleBadMail();
	}

	public void analysis(String newText) {
		int len = newText.length();
		float[] p = new float[len];
		// ���ձ�Ҷ˹��ʽ����
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
			System.out.println("p[" + i + "]��ֵΪ��" + p[i]);
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

		System.out.println("�������������ʼ��ĸ���Ϊ��" + (1 - result));
	}

	/**
	 * ����ͨ�ʼ����з��� Ϊ�˼򵥴������ǰ�һ��һ�ʴ����ݲ����зִ�
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
	 * �������ʼ����з��� Ϊ�˼򵥴������ǰ�һ��һ�ʴ����ݲ����зִ�
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
		beiyesi.analysis("�Ա��Ǹ�С椣����");
	}

}
