package com.springboot.Sqlconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class BookDao {
	public void insert(String Title, String author, String edition, String Genre) throws Exception {
		Connection con = MySqlConnection.getConnection();
		String insertsql = "insert into book(Title,author) values (?,?)";
		PreparedStatement ps = con.prepareStatement(insertsql);
		ps.setString(1, Title);
		ps.setString(2, author);
		ps.setString(3,edition);
		ps.setString(4, Genre);
		ps.executeUpdate();
	}
	public void update(String Title, String author, String edition, String Genre) throws Exception {
		Connection con = MySqlConnection.getConnection();
		String updatesql = "update book set Title=?, author=?, edition=? Genre=?";
		PreparedStatement ps1 = con.prepareStatement(updatesql);
		ps1.setString(1, Title);
		ps1.setString(2, author);
		ps1.setString(3, edition);
		ps1.setString(4, Genre);
		ps1.executeUpdate();
	}
		
	public void getAll() throws Exception {
		Connection con = MySqlConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(RETRIEVE_SQL);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			System.out.println("Title: " + rs.getString("Title") + " ;author: " + rs.getInt("author"));
		}
	}

	public static final String INSERT_SQL = "insert into book(Title,author) values (?,?)";

	public static final String RETRIEVE_SQL = "select Title,author from book";

}
