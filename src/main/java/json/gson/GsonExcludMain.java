package json.gson;

import json.Auction;
import json.Category;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonExcludMain {

	public static void main(String[] args) {
		
		Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategyImpl()).create();
		
		Category category = new Category();
		Auction auction = new Auction(110, "a", category);
		
		System.out.println(gson.toJson(auction));
	}
	
	/**
	 * ¶¨ÖÆ£ºÅÅ³ýfield²ßÂÔ
	 * @author bohan.sj
	 */
	public static class ExclusionStrategyImpl implements ExclusionStrategy {

		@Override
        public boolean shouldSkipField(FieldAttributes f) {
			if(f.getName().equals("category")) {
				return true;
			} else {
				return false;
			}
        }

		@Override
        public boolean shouldSkipClass(Class<?> clazz) {
	        return false;
        }
	}
	
}
