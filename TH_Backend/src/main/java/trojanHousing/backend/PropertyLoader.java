package trojanHousing.backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import trojanHousing.backend.entity.Property;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



public class PropertyLoader {

	
	public static void main (String[] args) {
		String name1 = "listings.json";
		String name2 = "images.json";
		File listingsFile = new File(name1);
		File imageFile = new File(name2);
		Scanner sc1;
		Scanner sc2;
		List<List<String>> urls = new ArrayList<List<String>>();
		List<ListingReader> listingReaders = new ArrayList<ListingReader>();
		try {
			sc1 = new Scanner(listingsFile);
			String temp1 = "";
			while(sc1.hasNext()) {
				temp1 += sc1.nextLine();
			}
			sc1.close();
			Type listType1 = new TypeToken<ArrayList<ListingReader>>(){}.getType();
			Gson gson = new Gson();
			listingReaders = gson.fromJson(temp1, listType1); 
			sc2 = new Scanner(imageFile);
			String temp2 = "";
			while(sc2.hasNext()) {
				temp2 += sc2.nextLine();
			}
			sc2.close();
			Type listType2 = new TypeToken<ArrayList<List<String>>>(){}.getType();
			urls = gson.fromJson(temp2, listType2); 
			int j = 0;
	        for (ListingReader lr : listingReaders) {
	            Property property = new Property();
	            property.setAddress(lr.getStreetAddress());
	            property.setAverageRating(2.5);
	            property.setBaths((int)lr.getBathrooms());
	            property.setBeds(lr.getBedrooms());
	            property.setDescription(lr.getDescription());
	            property.setDistance(lr.getDistance());
	            property.setPrice(lr.getPrice());
	            property.setTopPicture(urls.get(j).getFirst());
	            addProperties(property);
	            j++;
	        }
	        
			int i = 1;
	        for (List<String> urlList : urls) {
	            for (String url : urlList) {
	                addImage(url,i);
	            }
	            i++;
	        }
	        
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void addProperties(Property property) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/trojanhousingdb?user=root&password=root");
			ps = conn.prepareStatement("INSERT INTO rental_listings (address,average_rating,baths,beds,description,distance,price,top_picture) VALUES(?,?,?,?,?,?,?,?)");
			ps.setString(1, property.getAddress());
			ps.setDouble(2, property.getAverageRating());
			ps.setInt(3, property.getBaths());
			ps.setInt(4, property.getBeds());
			ps.setString(5, property.getDescription());
			ps.setDouble(6, property.getDistance());
			ps.setDouble(7,property.getPrice());
			ps.setString(8, property.getTopPicture());
			ps.execute();
		} catch(SQLException sqle) {
			System.out.println("SQLException in registerUser. ");
			sqle.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				} if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
		}
	}
	public static void addImage(String url, int propertyID) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/trojanhousingdb?user=root&password=root");
			ps = conn.prepareStatement("INSERT INTO images (imageurl,propertyid) VALUES(?,?)");
			ps.setString(1, url);
			ps.setInt(2, propertyID);
			ps.execute();
		} catch(SQLException sqle) {
			System.out.println("SQLException in registerUser. ");
			sqle.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				} if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle: " + sqle.getMessage());
			}
		}
	}
}
