package com.springboot.Sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {

	/**
	 * Making the class a singleton.
	 */
	private MySqlConnection() {
	};

	/**
	 * This method returns a connection to the MySQL database
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		if (connection == null) {
			synchronized (Connection.class) {
				
				// double checked locking
				if (connection == null) { //We are checking again in case of multithreaded access, thread 2 at this point will have connection == null and the resource needs to be instantiated again which is expensive
					try {
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						connection = DriverManager.getConnection(connection_string, username, password);
						System.out.println("Database connection with MYSQL established");
					} catch (Exception e) {
						throw new Exception("Error connecting to database");
					}
				}
			}
		}
		return connection;
	}

	private static String connection_string = "jdbc:mysql://localhost:3306/ex";
	private static String username = "root";
	private static String password = "password";
	private static Connection connection = null;
}
