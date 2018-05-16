package com.springboot.Sqlconnection;

import java.sql.Connection;

public class BookDemo {
	public static void main(String args[]) throws Exception {
		try {
			Connection con	= MySqlConnection.getConnection();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		
		
		BookDao book = new BookDao();
		book.insert("complete reference","herbet", "7th edition", "Edcuation");
		book.getAll();
		
	}
}
