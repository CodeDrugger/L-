package lab2.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import lab2.domain.Book;

public class UpdateService {
	public ArrayList<Object> exUpdate(Book book)
	{
		ArrayList<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://sndewvouswnf.rds.sae.sina.com.cn:10589/bookdb","lab2_user","123456");
			Statement stmt = connect.createStatement();
			stmt.executeUpdate(
					"update book set"
					+ " authorid=\'" + book.getAuthorid() + "\'"
					+ ", publisher=\'" + book.getPublisher() + "\'"
					+ ", publishdate=\'" + book.getPublishdate() + "\'"
					+ ", price=\'" + book.getPrice() + "\'"
					+ " where title=\'" + book.getTitle() + "\';");
			ResultSet rs = stmt.executeQuery("select * from book");
			while(rs.next())
			{
				Book bk = new Book();
				bk.setAuthorid(rs.getString("authorid"));
		    	bk.setIsbn(rs.getString("isbn"));
		    	bk.setPrice(rs.getString("price"));
		    	bk.setPublishdate(rs.getDate("publishdate"));
		    	bk.setPublisher(rs.getString("publisher"));
		    	bk.setTitle(rs.getString("title"));
		    	list.add(bk);
			}
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
