package json.gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import json.Auction;
import json.Category;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class GsonExampleMain {

	@SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {

		Gson gson = new Gson();
		
		/*
		 * list
		 */
		List<Auction> list = new ArrayList<Auction>();
		for(int i=0; i<3; i++) {
			list.add(new Auction(i, "t-" + i));
		}
		System.out.println(gson.toJson(list));
		
		/*
		 * map
		 */
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "json");
		map.put("bool", Boolean.TRUE);
		map.put("int", new Integer(110));
		map.put("arr", new String[]{"a", "b"});
		map.put("func", "function(i){return this.arr[i];}");
		Category category = new Category();
		category.setName("CN");
		map.put("category", category);
		System.out.println(gson.toJson(map));
		
		/*
		 * map key is object : {"json.Auction@1457cb":{"id":0}}
		 */
		Map<Auction, Category> complexMap = new HashMap<Auction, Category>();
		complexMap.put(new Auction(110,"auctions"), new Category());
		System.out.println(gson.toJson(complexMap));
		
		/*
		 * nested object
		 */
		Category cat = new Category();
		Auction auction = new Auction(110, "AA", cat);
		System.out.println(gson.toJson(auction));
		
		/*
		 * null
		 */
		System.out.println(gson.toJson(null));
		
		
		/*
		 * null field
		 */
		DsrDo dd = new DsrDo();
		dd.setDsr("4.5");
		dd.setDsrGap(null);
		String ddvalue = gson.toJson(dd);
		JsonParser ddparser = new JsonParser();
		JsonObject ddo = ddparser.parse(ddvalue).getAsJsonObject();
		//System.out.println("null field : " + ddo.get("dsrGap").getAsString());
		if(null instanceof JsonPrimitive) {
			System.out.println("null is JsonPrimitive"); 
		}
		
		
		/*
		 * Class
		 */
		Class clazz = DsrDo.class;
		DsrDo d = new DsrDo();
		d.setDsr("4.5");
		d.setDsrGap("-0.2");
		String value = gson.toJson(d);
		DsrDo dde = gson.fromJson(value, clazz);
		System.out.println(dde.getDsr());

		
		/*
		 * string to jsonObject 
		 */
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse("{\"auctionId\":\"110\",\"title\":\"AA\",\"category\":\"110\"}");
		System.out.println(element.getAsJsonObject().get("auctionId"));
		
		/*
		 * all field is null
		 */
		DsrDo dsrNull = new DsrDo();
		System.out.println(gson.toJson(dsrNull));
		
		/*
		 * partition field is null
		 */
		DsrDo dsrPartNull = new DsrDo();
		dsrPartNull.setDsr("{\"k1\":110}");
		String str = gson.toJson(dsrPartNull);
		System.out.println(str);
		dsrPartNull = gson.fromJson(str, DsrDo.class);
		System.out.println(gson.toJson(dsrPartNull));
	}	

}
