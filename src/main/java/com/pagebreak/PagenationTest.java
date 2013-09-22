package com.pagebreak;

public class PagenationTest {

	public static void main(String[] args) {
		int currentPage = 6;
		int totalPage = 50;
		System.out.println(getPagesString(currentPage, totalPage));
	}

	/**
	 * <pre>
	 * 显示规则：
	 * 属性：总页数totalPages=20,页码总结显示个数=6(前面1,后面4)
	 * 注释：totalPages<6,显示全部页码 1,2,3,4,5,6
	 *  a.currentPage=1,2  1,2,3,4,5,6...
	 *  b.3<=currentPage<=(totalPages-4) ...8,[9],10,11,12,13...
	 *  c.currentPage>(totalPages-4)  ...15,16,17,18,19,20
	 * </pre>
	 */
	public static String getPagesString(int currentPage, int totalPage) {

		StringBuffer result = new StringBuffer(""); 
		
		/*
		 * 判断总页数totalPage<=6
		 * 1.true,显示全部页数
		 * 2.false,进一步处理(计算显示 ...)
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
		
		else {//总页数>6
			
			if (currentPage <= 2) {//当前页<=2
				return getPagesString(currentPage, 6) + " …";
			} 
			
			else {//当前页>2
				result.append("… ");
				for (int i = currentPage - 1; i <= currentPage + 4; i++) {
					if (i == currentPage) {
						result.append("[" + i + "] ");
					} else {
						result.append(i + " ");
					}
				}
				if (totalPage > currentPage + 4) {
					result.append("… ");
				}
			}
		}
		return result.toString();
	}
	


}
