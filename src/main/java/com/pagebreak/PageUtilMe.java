package com.pagebreak;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PageUtilMe {
	
	
	/**
	 * <pre>
	 * 根据规则生成分页信息
	 * 显示规则：
	 * 属性：总页数totalPages=20,页码总结显示个数=6(前面1,后面4)
	 * 注释：totalPages<6,显示全部页码 1,2,3,4,5,6
	 * 	a.currentPage=1,2  1,2,3,4,5,6...
	 * 	b.3<=currentPage<=(totalPages-4) ...8,[9],10,11,12,13...
	 * 	c.currentPage>(totalPages-4)  ...15,16,17,18,19,20
	 * </pre>
	 * @param String url地址
	 * @param Map<PageBreakInfo, Integer> 分页信息
	 * <pre>
	 * a. 当前页 currentPageNum
	 * b. 总页数 totalPages
	 * c. 显示页码个数 showPageNumCounts
	 * </pre>
	 * @param Map<String, String> 参数信息
	 * @return String
	 * Apr 15, 2010 10:09:10 PM
	 * jueyuan
	 * 
	 */
	public static String generateBreakPageInfo(String url, 
			Map<PageBreakInfo, Integer> breakPageInfo, Map<String, String> paras) {
		
		
		int currentPageNum = breakPageInfo.get(PageBreakInfo.currentPageNum);
		int totalPages = breakPageInfo.get(PageBreakInfo.totalPages);
		int showPageNumCounts = breakPageInfo.get(PageBreakInfo.showPageNumCounts);
		
		
		StringBuffer[] urlInfos = new StringBuffer[showPageNumCounts];
		for(int i=0; i<showPageNumCounts; i++) {
			urlInfos[i] = new StringBuffer("");
		}
		
		/*
		 * 构造url,生成如下格式:
		 * <a href="url?prar1=valu1&p2=v2"
		 */
		for(StringBuffer eachUrl : urlInfos) {
			eachUrl.append("<a href=\"" + url + "?");
			Set<String>  parasKey = paras.keySet();
			int i = 0;
			for(Iterator<String> keys = parasKey.iterator(); keys.hasNext(); ) {
				i++;
				String key = keys.next();
				eachUrl.append(key + "=" + paras.get(key));
				if(i < paras.size()) {
					eachUrl.append("&");
				} 
			}
			eachUrl.append("\" ");
		}
		
		/*
		 * 判断总页数totalPage<=showPageNumCounts
		 * 1.true,显示全部页数
		 * 2.false,进一步处理(计算显示 ...)
		 */
		if (totalPages <= showPageNumCounts) {
			for (int i = 1; i <= showPageNumCounts; i++) {
				if (i == currentPageNum) {
					urlInfos[i].append(" class=\"pop\">" + i + "</a> ");
				} else {
					urlInfos[i].append(">" + i + "</a> ");
				}
			}
			return completeBreakPageInfos(urlInfos);
		} 
		
		else {//totalPage>showPageNumCounts
			
			if (currentPageNum <= 2) {//currentPageNum<=2,显示前showPageNumCounts条
				for(int i=0; i<showPageNumCounts; i++) {
					if (i == currentPageNum-1) {
						urlInfos[i].append("class=\"pop\">" + (i+1) + "</a> ");
					} else if(i == showPageNumCounts-1) {
						urlInfos[i].append(">" + (i+1) + "</a>...");
					} else {
						urlInfos[i].append(">" + (i+1) + "</a>");
					}
				}
				return completeBreakPageInfos(urlInfos);
			} 
			
			else {//当前页>2
				urlInfos[0].insert(0, "... ");
				for (int i = currentPageNum - 1,j=0; i <= currentPageNum + 4; i++,j++) {
					if (i == currentPageNum) {
						urlInfos[j].append("class=\"pop\">" + i + "</a> ");
					} else {
						urlInfos[j].append(">" + i + "</a> ");
					}
					
					if(i >= totalPages) break;
				}
				if (totalPages> currentPageNum + 4) {
					urlInfos[showPageNumCounts-1].append("...");
				}
			}
		}
		return completeBreakPageInfos(urlInfos); 
		
	}
	
	private static String completeBreakPageInfos(StringBuffer[] sb) {
		StringBuffer breakPageInfos = new StringBuffer("");
		for(StringBuffer str : sb) {
			breakPageInfos.append(str.toString() + "\n");
		}
		return breakPageInfos.toString();
	}
	
	
	public static void main(String[] args) {
		String url = "blacklist_home.htm";
		
		Map<PageBreakInfo, Integer> pageInfos = new HashMap<PageBreakInfo, Integer>();
		pageInfos.put(PageBreakInfo.totalPages, 20);
		pageInfos.put(PageBreakInfo.currentPageNum, 19);
		pageInfos.put(PageBreakInfo.showPageNumCounts, 6);
		
		Map<String, String> paras = new HashMap<String, String>();
		paras.put("p1", "v1");
		paras.put("p2", "v2");
		
		
		
		
		System.out.println(generateBreakPageInfo(url, pageInfos, paras));
		
		
	}

}
