package lab2;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;

import lab2.domain.Author;
import lab2.domain.Book;
import lab2.service.AuthorService;

public class AuthorSearch implements Action {

	private Author author;
	private ArrayList<Book> list;
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public ArrayList<Book> getList() {
		return list;
	}
	public void setList(ArrayList<Book> list) {
		this.list = list;
	}
	@Override
	public String execute() throws Exception {
		AuthorService as = new AuthorService();
		if (author.getAuthorname().length() == 0)
			return ERROR;
		setList(as.CheckDatabase(author));
		if (getList() != null)
			return SUCCESS;
		else
			return "noresult";
	}

}
