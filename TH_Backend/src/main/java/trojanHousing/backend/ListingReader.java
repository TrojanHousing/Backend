package trojanHousing.backend;

public class ListingReader {
	private String description;
	private int price;
	private int bedrooms;
	private double bathrooms;
	public double getBathrooms() {
		return bathrooms;
	}
	public void setBathrooms(double bathrooms) {
		this.bathrooms = bathrooms;
	}
	private String streetAddress;
	private double distance;
	private String topPicture;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBedrooms() {
		return bedrooms;
	}
	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getTopPicture() {
		return topPicture;
	}
	public void setTopPicture(String topPicture) {
		this.topPicture = topPicture;
	}
	
}
