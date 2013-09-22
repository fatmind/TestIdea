package json.jsonlib;

import java.util.HashMap;
import java.util.Map;

import json.Category;

import net.sf.json.JSONObject;

public class SimpleMapToJson {

	public static void main(String[] args) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", "json");
		map.put("bool", Boolean.TRUE);

		map.put("int", new Integer(110));
		map.put("int", 110);
		map.put("arr", new String[]{"a", "b"});
		
		//"func":function(i){return this.arr[i];} Ϊʲôvalue��˫���� ?
		//map.put("func", "function(i){return this.arr[i];}");
		
		Category category = new Category();
		category.setName("CN");
		map.put("category", category);
		
		/*
		 * map����֧��keyΪString����
		 */
		JSONObject json = JSONObject.fromObject(map);
		System.out.println(json.toString());
		
		
	}

}
