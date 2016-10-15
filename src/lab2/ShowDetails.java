package lab2;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;

import lab2.domain.Author;
import lab2.domain.Book;
import lab2.service.ShowDetailsService;

public class ShowDetails implements Action {
	private Book bookname;
	private Author sauthor;
	
	public ShowDetails() {
		sauthor = new Author();
	}

	public Book getBookname() {
		return bookname;
	}

	public void setBookname(Book bookname) {
		this.bookname = bookname;
	}
	
	
	public Author getSauthor() {
		return sauthor;
	}

	public void setSauthor(Author sauthor) {
		this.sauthor = sauthor;
	}

	@Override
	public String execute() throws Exception {
		ShowDetailsService sds = new ShowDetailsService();
		ArrayList<Object> infoset = sds.ShowInfo(bookname);
		try {
			sauthor.Copy((Author)infoset.get(1));
			bookname.Copy((Book)infoset.get(0));
		} catch (Exception e) {
			return ERROR;
		}		
		return SUCCESS;
	}
}
