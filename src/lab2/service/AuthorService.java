package lab2.service;

import java.sql.*;
import java.util.ArrayList;

import lab2.domain.*;


public class AuthorService {
	
	public ArrayList<Book> CheckDatabase(Author author) {
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://sndewvouswnf.rds.sae.sina.com.cn:10589/bookdb","lab2_user","123456");
			Statement stmt = connect.createStatement();
		    ResultSet rs = stmt.executeQuery("select * from author where name='"+ author.getAuthorname() + "'");
		    if (rs.next() == false)
		    {
		    	connect.close();
		    	return null;		    	
		    }
		    ResultSet rst = stmt.executeQuery("select * from book where authorid='"+ rs.getString("authorid") + "'");		
		    while(rst.next())
		    {
		    	Book book = new Book();
		    	book.setIsbn(rst.getString("isbn"));
		    	book.setTitle(rst.getString("title"));
		    	book.setAuthorid(rst.getString("authorid"));
		    	book.setPublisher(rst.getString("publisher"));
		    	book.setPublishdate(rst.getDate("publishdate"));
		    	book.setPrice(rst.getString("price"));
		    	list.add(book);
		    }
		    connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
