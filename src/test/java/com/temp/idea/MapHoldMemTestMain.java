package com.temp.idea;

import java.util.HashMap;

/**
 * -Xmx1024M -Xms1024M
 * 120-10 = 110*1024 / 1000000 = 0.112K
 * @author bohan.sj
 */
public class MapHoldMemTestMain {

	
	public static void main(String[] args) throws Exception {
		String value = "{itemURL:http://item.taobao.com/item.htm?id=9263064114&ad_id=&am_id=&cm_id=&pm_id=," +
				"itemTitle:蓝天LT828 天翼189老年人手机 CDMA电信老人手机 支持C网 大字体," +
				"pictureUrl:http://img03.taobaocdn.com/bao/uploaded/i3/T1xbmbXiRpXXc0gRna_091824.jpg_310x310.jpg" +
				"activityPrice:98.00" +
				"originalPrice:120.00" +
				"shopName:阿尔卡特朗玛专卖店}";
		
		HashMap<String, String> cache = new HashMap<String, String>();
		
		Thread.sleep(1000 * 30);
		
		System.out.println("starting ...");
		
		for(int i=0; i<1000000; i++) {
			cache.put("key-" + i, value);
			if(i == 500000) {
				System.out.println("doning ...");
			}
		}
		
		System.out.println("complete ...");
		
		Thread.sleep(1000 * 60);
		
	}

}
