package com.java.jdbc;

public class Restaurant {
	
	private int RestaurantId ;
	private String RestaurantName ;
	private String RestaurantCity  ;
	private double   Mobile ; 
	
	public int getRestaurantId() {
		return RestaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		RestaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return RestaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		RestaurantName = restaurantName;
	}

	public String getRestaurantCity() {
		return RestaurantCity;
	}

	public void setRestaurantCity(String restaurantCity) {
		RestaurantCity = restaurantCity;
	}

	public double getMobile() {
		return Mobile;
	}

	public void setMobile(double mobile) {
		Mobile = mobile;
	}

	

	@Override
	public String toString() {
		return "Restaurant [RestaurantId=" + RestaurantId + ", RestaurantName=" + RestaurantName + ", RestaurantCity="
				+ RestaurantCity + ", Mobile=" + Mobile + "]";
	}

	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

}
