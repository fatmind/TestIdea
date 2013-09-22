package json.jsonlib;

import java.util.ArrayList;
import java.util.List;

import json.Auction;

import net.sf.json.JSONArray;

public class ListToJson {

	public static void main(String[] args) {
		
		JSONArray jsonArray = new JSONArray();
		
		List<Auction> list = new ArrayList<Auction>();
		for(int i=0; i<3; i++) {
			Auction auction = new Auction();
			auction.setAuctionId(i);
			auction.setTitle("title-" + i);
			list.add(auction);
		}
		
		if(jsonArray.addAll(list)) {
			System.out.println(jsonArray.toString());
		} else {
			System.out.println("add to json array fail"); 
		}
	}

}
