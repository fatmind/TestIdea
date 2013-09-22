package com.pagebreak;

public class PagenationTest {

	public static void main(String[] args) {
		int currentPage = 6;
		int totalPage = 50;
		System.out.println(getPagesString(currentPage, totalPage));
	}

	/**
	 * <pre>
	 * ��ʾ����
	 * ���ԣ���ҳ��totalPages=20,ҳ���ܽ���ʾ����=6(ǰ��1,����4)
	 * ע�ͣ�totalPages<6,��ʾȫ��ҳ�� 1,2,3,4,5,6
	 *  a.currentPage=1,2  1,2,3,4,5,6...
	 *  b.3<=currentPage<=(totalPages-4) ...8,[9],10,11,12,13...
	 *  c.currentPage>(totalPages-4)  ...15,16,17,18,19,20
	 * </pre>
	 */
	public static String getPagesString(int currentPage, int totalPage) {

		StringBuffer result = new StringBuffer(""); 
		
		/*
		 * �ж���ҳ��totalPage<=6
		 * 1.true,��ʾȫ��ҳ��
		 * 2.false,��һ������(������ʾ ...)
		 */
		if (totalPage <= 6) {
			for (int i = 1; i <= 6; i++) {
				if (i == currentPage) {
					result.append("[" + i + "] ");
				} else {
					result.append(i + " ");
				}
			}
		} 
		
		else {//��ҳ��>6
			
			if (currentPage <= 2) {//��ǰҳ<=2
				return getPagesString(currentPage, 6) + " ��";
			} 
			
			else {//��ǰҳ>2
				result.append("�� ");
				for (int i = currentPage - 1; i <= currentPage + 4; i++) {
					if (i == currentPage) {
						result.append("[" + i + "] ");
					} else {
						result.append(i + " ");
					}
				}
				if (totalPage > currentPage + 4) {
					result.append("�� ");
				}
			}
		}
		return result.toString();
	}
	


}
