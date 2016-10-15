package lab2.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import lab2.domain.Author;
import lab2.domain.Book;

public class AddService {
	private ArrayList<Object> list;
	public AddService() {
		list = new ArrayList<>();
	}
	
	public ArrayList<Object> getList() {
		return list;
	}

	public void setList(ArrayList<Object> list) {
		this.list = list;
	}

	public int exAdd(Book book, Author author)
	{
		int state = 0;//0:无作者,1:成功加入,-1:已存在,-2:检查输入
		boolean yourmistake = 
				book.getAuthorid().length() == 0 ||
				book.getIsbn().length() == 0 ||
				book.getPrice().length() == 0 ||
				book.getPublishdate() == null ||
				book.getPublisher().length() == 0 ||
				book.getTitle().length() == 0;
		if (yourmistake) return -2;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://sndewvouswnf.rds.sae.sina.com.cn:10589/bookdb","lab2_user","123456");
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from author where authorid=\'" + book.getAuthorid() +"\';");
			boolean dobk = rs.next();
			if (dobk)//正事
			{
				ResultSet rst = stmt.executeQuery("select * from book where isbn=\'" + book.getIsbn() +"\';");
				if (rst.next() == false)
				{
					stmt.executeUpdate("insert into book ("
							+ "isbn,title,authorid,publisher,publishdate,price) values ("
							+ "\'" + book.getIsbn() + "\',"
							+ "\'" + book.getTitle() + "\',"
							+ "\'" + book.getAuthorid() + "\',"
							+ "\'" + book.getPublisher() + "\',"
							+ "\'" + book.getPublishdate() + "\',"
							+ "\'" + book.getPrice() + "\');");
					ResultSet rs1 = stmt.executeQuery("select * from book");
					while(rs1.next())
					{
						Book bk = new Book();
						bk.setAuthorid(rs1.getString("authorid"));
				    	bk.setIsbn(rs1.getString("isbn"));
				    	bk.setPrice(rs1.getString("price"));
				    	bk.setPublishdate(rs1.getDate("publishdate"));
				    	bk.setPublisher(rs1.getString("publisher"));
				    	bk.setTitle(rs1.getString("title"));
				    	list.add(bk);
					}
					connect.close();
					state = 1;
					return state;
				}
				else
				{
					state = -1;
					connect.close();
					return state;
				}
			}
			else if (!dobk && author == null)//没作者
			{
				connect.close();
				state = 0;
				return state;
			}
			else//有作者了
			{
				yourmistake = 
						author.getAge() == "" ||
						author.getAuthorname() == "" ||
						author.getCountry() == "";
				if (yourmistake) return -3;
				ResultSet rst = stmt.executeQuery("select * from book where isbn=\'" + book.getIsbn() +"\';");
				boolean dobo = !(rst.next());
				ResultSet rest = stmt.executeQuery("select * from author where authorid=\'" + author.getAuthorid() +"\';");
				boolean doau = !(rest.next());
				if (dobo && doau)
				{
					stmt.executeUpdate("insert into book ("
							+ "isbn,title,authorid,publisher,publishdate,price) values ("
							+ "\'" + book.getIsbn() + "\',"
							+ "\'" + book.getTitle() + "\',"
							+ "\'" + book.getAuthorid() + "\',"
							+ "\'" + book.getPublisher() + "\',"
							+ "\'" + book.getPublishdate() + "\',"
							+ "\'" + book.getPrice() + "\');");
					stmt.executeUpdate("insert into author ("
							+ "authorid,name,age,country) values ("
							+ "\'" + author.getAuthorid() + "\',"
							+ "\'" + author.getAuthorname() + "\',"
							+ "\'" + author.getAge() + "\',"
							+ "\'" + author.getCountry() + "\');");
					ResultSet rs2 = stmt.executeQuery("select * from book");
					while(rs2.next())
					{
						Book bk = new Book();
						bk.setAuthorid(rs2.getString("authorid"));
				    	bk.setIsbn(rs2.getString("isbn"));
				    	bk.setPrice(rs2.getString("price"));
				    	bk.setPublishdate(rs2.getDate("publishdate"));
				    	bk.setPublisher(rs2.getString("publisher"));
				    	bk.setTitle(rs2.getString("title"));
				    	list.add(bk);
					}
					connect.close();
					state = 1;
					return state;
				}
				else
				{
					state = -1;
					connect.close();
					return state;
				}				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
}
