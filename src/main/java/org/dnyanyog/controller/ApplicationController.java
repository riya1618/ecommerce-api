package org.dnyanyog.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

	@GetMapping("/logindata")
	public String loginData() throws SQLException {

		String url = "jdbc:mysql://localhost:3306/ecommerce";
		String dbUsername = "root";
		String dbPassword = "Riya@1618";

		Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
		Statement statement = connection.createStatement();

//		ResultSet result = statement.executeQuery("SELECT * FROM users  ");
//		String name = "";
//		while (result.next()) {
//			System.out.println("User Name:" + result.getString(1) + "\nUser Password: " + result.getString(3));
//			name = result.getString(1);
//		}
//		return name;
		String username="";
		ResultSet result = statement.executeQuery("SELECT username FROM users where password='Riya@1618';");
		
		if (result.next()) {
            username = result.getString("username");
            System.out.println("Username: " + username);
        } else {
            System.out.println("No user found with the given password.");
        }
		
		return username;
		
	}
}
