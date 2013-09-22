package com.pagebreak;

import java.util.HashMap;
import java.util.Map;

public class PageUtil {
	/**
	 * 方法描述：生成分页器的方法
	 * 创建人：<a href="mailto:duanyu@taobao.com">duanyu</a> <br/>
	 * 创建时间：Apr 15, 2010 3:29:34 PM  <br/>
	 * @param currentPage 当前页
	 * @param totalPage	  总页数
	 * @param url		  不带参数的url
	 * @param currentPageKey 当前页的参数key
	 * @param cssMap	css的属性映射，当前页的key为cur，链接的key为href，省略号的key为ellipsis
	 * @param paramsMap	queryString的map，key为查询字符串的key，value为查询字符串的value
	 * @return 分页器字符串
	 */
	public static String getPagesString(int currentPage,int totalPage,String url,String currentPageKey,Map<String, String> cssMap,Map<String, String> paramsMap){
		
		StringBuffer sbf=new StringBuffer();
		String curCss=cssMap.get("cur");
		String hrefCss=cssMap.get("href");
		String ellipsis=cssMap.get("ellipsis");
		
		if(currentPage>totalPage){
			currentPage=totalPage;
		}
		
		if(totalPage<=6){
			for(int i=1;i<=totalPage;i++){
				if(i==currentPage){
					sbf.append("<span ");
					if(curCss!=null&&!"".equals(curCss)){
					sbf.append("class=\"").append(curCss).append("\"");
					}
					sbf.append(">").append(i).append("</span>\n");
				}else{
					//paramsMap.put(currentPageKey, i+"");
					//String finalurl=getUrl(url, paramsMap);
					//sbf.append("<a href=\"").append(finalurl).append("\" ");
					
					if(null!=hrefCss&&!"".equals(hrefCss)){
						sbf.append("class=\"").append(hrefCss).append("\"");
					}
					sbf.append(">").append(i).append("</a>\n");
				}
			}
		}
		else {
			if(currentPage<=2){
				sbf=new StringBuffer(getPagesString(currentPage, 6, url, currentPageKey, cssMap, paramsMap));
				sbf.append("<span class=\"").append(ellipsis).append("\">…").append("</span>");
				return sbf.toString();
			}
			else {
				sbf.append("<span class=\"").append(ellipsis).append("\">…").append("</span>");
				for(int i=currentPage-1;i<=currentPage+4;i++){
					if(i==currentPage){
						sbf.append("<span ");
						if(curCss!=null&&!"".equals(curCss)){
						sbf.append("class=\"").append(curCss).append("\"");
						}
						sbf.append(">").append(i).append("</span>\n");
					}else {
						paramsMap.put(currentPageKey, i+"");
						String finalurl=getUrl(url, paramsMap);
						sbf.append("<a href=\"").append(finalurl).append("\" ");
						
						if(null!=hrefCss&&!"".equals(hrefCss)){
							sbf.append("class=\"").append(hrefCss).append("\"");
						}
						sbf.append(">").append(i).append("</a>\n");
					}
					if(i>=totalPage)break;
				}
				if(totalPage>currentPage+4){
					sbf.append("<span class=\"").append(ellipsis).append("\">…").append("</span>");
				}
			}
		}
		return sbf.toString();
	}
	
	/**
	 * 方法描述：url组合器，将不带参数的url和参数map生成一个完整的url
	 * 创建人：<a href="mailto:duanyu@taobao.com">duanyu</a> <br/>
	 * 创建时间：Apr 15, 2010 3:41:46 PM  <br/>
	 * @param head
	 * @param params
	 * @return
	 */
	private static String getUrl(String head,Map<String, String> params){
		if(head.endsWith("?")){
			head=head.substring(0, head.length()-1);
		}
		StringBuffer sbf=new StringBuffer(head).append("?");
		int size=params.size();
		int i=1;
		for(String key:params.keySet()){
			sbf.append(key);
			sbf.append("=");
			if(null!=params.get(key)){
				sbf.append(params.get(key));
			}
			if(i<size){
				sbf.append("&");
			}
			i++;
		}
		return sbf.toString();
	}
	public static void main(String[] args) {
		int currentPage=19;
		int totalPage=20;
		Map<String, String> cssMap=new HashMap<String, String>();
		Map<String, String> paramsMap=new HashMap<String, String>();
		cssMap.put("cur", "cur-class");
		cssMap.put("href", "href-class");
		String url="manage_account.htm";
		paramsMap.put("hello", null);
		paramsMap.put("sc", "duanyu");
		System.out.println(getPagesString(currentPage, totalPage, url, "reqNum", cssMap, paramsMap));
	}
}
