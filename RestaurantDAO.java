package com.java.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAO {

	Connection con;
	PreparedStatement pst;
	
	public String updateRestaurant(Restaurant restaurant) throws ClassNotFoundException, SQLException {
		Restaurant restaurantFound = searchRestaurant(restaurant.getRestaurantId());
		if (restaurantFound!=null) {
			String cmd = "Update Restaurant set RestaurantName=?, RestaurantCity=?,"+" Mobile=? Where RestaurantId=?";
			pst = con.prepareStatement(cmd);
			pst.setString(1, restaurant.getRestaurantName());
			pst.setString(2, restaurant.getRestaurantCity());
			pst.setDouble(3, restaurant.getMobile());
			pst.setInt(4, restaurant.getRestaurantId());
			pst.executeUpdate();
			return "Record Updated...";
		}
		return "Record Not Found...";
	}
	public String deleteRestaurant(int RestaurantId) throws ClassNotFoundException, SQLException {
		Restaurant restaurant = searchRestaurant(RestaurantId);
		if (restaurant!=null) {
			con = ConnectionHelper.getConnection();
			String cmd = "Delete From Restaurant where RestaurantId=?";
			pst = con.prepareStatement(cmd);
			pst.setInt(1,RestaurantId );
			pst.executeUpdate();
			return "Record Deleted...";
		}
		return "Record Not Found...";
	}
	public String addRestaurant(Restaurant restaurant) throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "Insert into Restaurant(RestaurantName,RestaurantCity,Mobile) "
				+ " values(?,?,?,?,?)";
		pst = con.prepareStatement(cmd);
		pst.setString(1, restaurant.getRestaurantName());
		pst.setString(2, restaurant.getRestaurantCity());
		pst.setDouble(3, restaurant.getMobile());
		pst.setInt(4, restaurant.getRestaurantId());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	
	public Restaurant searchRestaurant(int RestaurantId) throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "select * from Restaurant where RestaurantId=?";
		pst = con.prepareStatement(cmd);
		pst.setInt(1, RestaurantId);
		ResultSet rs = pst.executeQuery();
		Restaurant restaurant = null;
		if (rs.next()) {
			restaurant = new Restaurant();
			restaurant.setRestaurantId(rs.getInt("RestaurantId"));
			restaurant.setRestaurantName(rs.getString("RestaurantName"));
			restaurant.setRestaurantCity(rs.getString("RestaurantCity"));
			restaurant.setMobile(rs.getDouble("Mobile"));			
		}
		return restaurant;
	}
	
	    public List<Restaurant> showRestaurant() throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "select * from Restaurant";
		pst = con.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
		Restaurant restaurant = null;
		while(rs.next()) {
			restaurant = new Restaurant();
			restaurant.setRestaurantId(rs.getInt("RestaurantId"));
			restaurant.setRestaurantName(rs.getString("RestaurantName"));
			restaurant.setRestaurantCity(rs.getString("RestaurantCity"));
			restaurant.setMobile(rs.getDouble("Mobile"));
			restaurantList.add(restaurant);
		}
		return restaurantList;
	}
}