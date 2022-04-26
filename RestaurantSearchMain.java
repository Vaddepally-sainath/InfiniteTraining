package com.java.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class RestaurantSearchMain {

	public static void main(String[] args) {
		RestaurantDAO dao = new RestaurantDAO();
		int RestaurantId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter RestaurantId  ");
		RestaurantId = sc.nextInt();
		try {
			Restaurant restaurant = dao.searchRestaurant(RestaurantId);
			if (restaurant!=null) {
				System.out.println(restaurant);
			} else {
				System.out.println("*** Record Not Found ***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
