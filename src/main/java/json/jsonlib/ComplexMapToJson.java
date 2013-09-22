package json.jsonlib;

import java.util.HashMap;
import java.util.Map;

import json.Auction;
import json.Category;

public class ComplexMapToJson {
	
	public static void main(String[] args) {
		
		/*
		 * 闷头想想：
		 * name为对象，则会变成 {{}:{}} 其是不符合json标准的 
		 */
		Map<Object, Object> data = new HashMap<Object, Object>();
		for(int i=0; i<3; i++) {
			Category catDO = new Category();
			catDO.setId(i);
			catDO.setName("catName-" + i);
			Auction auction = new Auction();
			auction.setAuctionId(i);
			auction.setTitle("title-" + i);
			data.put(catDO, auction);
		}
		
/*		for(Entry<Object, Object> e : data.entrySet()) {
			
			StringBuilder sb = new StringBuilder();
			
			JSONObject jsonObject = JSONObject.fromObject(e.getKey());
			sb.append(jsonObject.toString());
			sb.replace(sb.length()-1, sb.length(), "");
			
			Object value = e.getValue();
			if(value instanceof ArrayList) {
				sb.append("values:[");
				@SuppressWarnings("unchecked")
				ArrayList<Object> realValue = (ArrayList<Object>)value;
				for(Object obj : realValue) {
					sb.append(obj);
				}
				sb.append("]");
			} else {
				String valueStr = JSONObject.fromObject(value).toString();
				sb.append(",").append(valueStr.substring(1, valueStr.length()));
			}
			
			System.out.println(sb.toString());			
 		}*/

	}

}
