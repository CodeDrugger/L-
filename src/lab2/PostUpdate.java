package lab2;

import java.util.ArrayList;
import com.opensymphony.xwork2.Action;
import lab2.domain.Book;
import lab2.service.UpdateService;

public class PostUpdate implements Action {
	private Book book;
	private ArrayList<Object> list;
	private String note;
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public ArrayList<Object> getList() {
		return list;
	}

	public void setList(ArrayList<Object> list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {
		boolean yourmistake = 
				book.getAuthorid().length() == 0 ||
				book.getIsbn().length() == 0 ||
				book.getPrice().length() == 0 ||
				book.getPublishdate() == null ||
				book.getPublisher().length() == 0 ||
				book.getTitle().length() == 0;
		if (yourmistake)
			{
				setNote("«ÎºÏ≤È ‰»Î£°");
				return "invalid";			
			}
		UpdateService us = new UpdateService();
		setList(us.exUpdate(book));
		if (getList().size() == 0)			
			return ERROR;
		else
			return SUCCESS;
	}

}
