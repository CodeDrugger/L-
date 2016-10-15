package lab2.domain;

import java.sql.Date;

public class Book {
	private String isbn;
	private String title;
	private String authorid;
	private String publisher;
	private Date publishdate;
	private String price;
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorid() {
		return authorid;
	}
	public void setAuthorid(String authorid) {
		this.authorid = authorid;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public void Copy(Book bk)
	{
		this.setAuthorid(bk.getAuthorid());
		this.setIsbn(bk.getIsbn());
		this.setPrice(bk.getPrice());
		this.setPublishdate(bk.getPublishdate());
		this.setPublisher(bk.getPublisher());
		this.setTitle(bk.getTitle());
	}
}
