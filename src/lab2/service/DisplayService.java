package lab2.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import lab2.domain.Author;
import lab2.domain.Book;

public class DisplayService {
	public ArrayList<Object> Dispaly(int choice)
	{
		ArrayList<Object> list = new ArrayList<>();	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (choice == 1)
		{
			try {
				Connection connect = DriverManager.getConnection("jdbc:mysql://sndewvouswnf.rds.sae.sina.com.cn:10589/bookdb","lab2_user","123456");
				Statement stmt = connect.createStatement();
				ResultSet rs = stmt.executeQuery("select * from book");
				while(rs.next())
				{
					Book book = new Book();
					book.setAuthorid(rs.getString("authorid"));
			    	book.setIsbn(rs.getString("isbn"));
			    	book.setPrice(rs.getString("price"));
			    	book.setPublishdate(rs.getDate("publishdate"));
			    	book.setPublisher(rs.getString("publisher"));
			    	book.setTitle(rs.getString("title"));
			    	list.add(book);
				}
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		else if (choice == 2)
		{
			try {
				Connection connect = DriverManager.getConnection("jdbc:mysql://sndewvouswnf.rds.sae.sina.com.cn:10589/bookdb","lab2_user","123456");
				Statement stmt = connect.createStatement();
				ResultSet rst = stmt.executeQuery("select * from author");
				while(rst.next())
				{
					Author author = new Author();
					author.setAuthorid(Integer.parseInt(rst.getString("authorid")));
			    	author.setAuthorname(rst.getString("name"));
			    	author.setAge(rst.getString("age"));
			    	author.setCountry(rst.getString("country"));
			    	list.add(author);
				}
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return list;
	}
}
