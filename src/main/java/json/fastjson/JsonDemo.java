package json.fastjson;

import json.Category;

import com.alibaba.fastjson.JSONObject;

public class JsonDemo {

	public static void main(String[] args) {
		
		Category category = new Category();
		category.setId(110);
		category.setName("hello");
		
		String str = JSONObject.toJSON(category).toString();
		System.out.println(str);
		
		Category category2 = JSONObject.parseObject(str, Category.class);
		System.out.println(category2.getName());
		
		JSONObject json = (JSONObject)JSONObject.parse("{\"id\":110,\"name\":\"hello\"}");
		System.out.println(json.get("id"));
		System.out.println(json.get("name"));
		
	}

}
