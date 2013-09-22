package json;

public class Auction {

	private int auctionId;
	private String title;
	private Category category;
	
	public Auction() {
	}
	
	public Auction(int auctionId, String title) {
		this.auctionId = auctionId;
		this.title = title;
	}
	
	public Auction(int auctionId, String title, Category category) {
		this.auctionId = auctionId;
		this.title = title;
		this.category = category;
	}
	
	
	public int getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Category getCategory() {
    	return category;
    }
	public void setCategory(Category category) {
    	this.category = category;
    }
	
}
