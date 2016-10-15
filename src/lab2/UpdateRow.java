package lab2;

import com.opensymphony.xwork2.Action;

import lab2.domain.Book;

public class UpdateRow implements Action {
	private Book book;
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

	@Override
	public String execute() throws Exception {
		setNote("");
		return SUCCESS;
	}

}
