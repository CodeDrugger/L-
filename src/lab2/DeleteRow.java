package lab2;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;

import lab2.domain.Book;
import lab2.service.DeleteService;

public class DeleteRow implements Action {
	private Book book;
	private ArrayList<Object> list;
	
	public ArrayList<Object> getList() {
		return list;
	}

	public void setList(ArrayList<Object> list) {
		this.list = list;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String execute() throws Exception {
		DeleteService ds = new DeleteService();
		setList(ds.DelRow(getBook()));
		if (getList().size() == 0)			
			return ERROR;
		else
			return SUCCESS;
	}

}
