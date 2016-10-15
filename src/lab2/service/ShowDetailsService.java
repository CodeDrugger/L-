package lab2.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import lab2.domain.Author;
import lab2.domain.Book;

public class ShowDetailsService {
	public ArrayList<Object> ShowInfo(Book bookname)
	{
		ArrayList<Object> infoset = new ArrayList<>();
		Book book = new Book();
		Author author = new Author();
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://sndewvouswnf.rds.sae.sina.com.cn:10589/bookdb","lab2_user","123456");
			Statement stmt = connect.createStatement();
		    ResultSet rs = stmt.executeQuery("select * from book where title='"+ bookname.getTitle() + "'");
		    while(rs.next())
		    {
		    	book.setAuthorid(rs.getString("authorid"));
		    	book.setIsbn(rs.getString("isbn"));
		    	book.setPrice(rs.getString("price"));
		    	book.setPublishdate(rs.getDate("publishdate"));
		    	book.setPublisher(rs.getString("publisher"));
		    	book.setTitle(rs.getString("title"));
		    }
		    ResultSet rst = stmt.executeQuery("select * from author where authorid='"+ book.getAuthorid() + "'");
		    while(rst.next())
		    {
		    	author.setAuthorid(Integer.parseInt(rst.getString("authorid")));
		    	author.setAuthorname(rst.getString("name"));
		    	author.setAge(rst.getString("age"));
		    	author.setCountry(rst.getString("country"));
		    }
		    infoset.add(book);
		    infoset.add(author);
		    connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return infoset;
	}
}
