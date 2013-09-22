package json.gson;

import java.io.Serializable;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

public class GsonJsonObjectMain {

	public static void main(String[] args) {

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(CacheEntry.class, new CacheEntryDeserializer());
		Gson gson = gsonBuilder.create();
		
		CacheEntry cacheEntry = new CacheEntry();
		cacheEntry.setKey("123");
		
		DsrDo dsrDo = new DsrDo();
		dsrDo.setDsr("2.3");
		dsrDo.setDsrGap("-5.6");
		cacheEntry.setValue(dsrDo);
//		cacheEntry.setValue("hello");
		
		cacheEntry.setExpireTime(System.currentTimeMillis());
		
		String jsonRes = gson.toJson(cacheEntry);
		System.out.println(jsonRes);
		
		CacheEntry desCacheEntry = gson.fromJson(jsonRes, CacheEntry.class);
		System.out.println("key = " + desCacheEntry.getKey()); 
		System.out.println("value = " + desCacheEntry.getValue()); 
		System.out.println("expiredTime = " + desCacheEntry.getExpireTime());
	}

}


class CacheEntryDeserializer implements JsonDeserializer<CacheEntry> {

	@Override
    public CacheEntry deserialize(JsonElement json, Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException {
		CacheEntry entry = new CacheEntry();
		JsonObject jsonObject = json.getAsJsonObject();
		entry.setKey(jsonObject.get("key").getAsString());
		entry.setExpireTime(jsonObject.get("expireTime").getAsLong());
		//JsonPrimitive value = (JsonPrimitive)jsonObject.get("value");
		entry.setValue(jsonObject.get("value").toString());
	    return entry;
    } 
	
}

class CacheEntry implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
	private Serializable key;
	private Serializable value;
	private Long expireTime;
	
	public Serializable getKey() {
    	return key;
    }
	public void setKey(Serializable key) {
    	this.key = key;
    }
	public void setValue(Serializable value) {
    	this.value = value;
    }
	public Serializable getValue() {
    	return value;
    }
	public Long getExpireTime() {
    	return expireTime;
    }
	public void setExpireTime(Long expireTime) {
    	this.expireTime = expireTime;
    }
	
}

class DsrDo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String dsr;
    private String dsrGap;
    
	public String getDsr() {
    	return dsr;
    }
	public void setDsr(String dsr) {
    	this.dsr = dsr;
    }
	public String getDsrGap() {
    	return dsrGap;
    }
	public void setDsrGap(String dsrGap) {
    	this.dsrGap = dsrGap;
    }
	
}
