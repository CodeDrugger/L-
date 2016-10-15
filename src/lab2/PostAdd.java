package lab2;

import java.util.ArrayList;
import com.opensymphony.xwork2.Action;
import lab2.domain.Author;
import lab2.domain.Book;
import lab2.service.AddService;

public class PostAdd implements Action {
	private Book book;
	private Author author;
	private String note;
	private ArrayList<Object> list;
	
	public ArrayList<Object> getList() {
		return list;
	}

	public void setList(ArrayList<Object> list) {
		this.list = list;
	}

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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String execute() throws Exception {
		AddService as = new AddService();
		int state = as.exAdd(book, author);
		if (state == 0)
		{
			setNote("������������Ϣ������д������Ϣ");
			return "noauthor";
		}			
		else if(state == 1)
		{
			setList(as.getList());
			setNote(" ");
			return SUCCESS;
		}		
		else if(state == -2)
		{
			setNote("�������룡(���ڵĸ�ʽΪXXXX-XX-XX)");
			return ERROR;
		}
		else if(state == -3)
		{
			setNote("�������룡");
			return "noauthor";
		}
		else
		{
			setNote("����д����Ϣ�Ѵ��������ݿ��У�");
			return ERROR;
		}	
	}

}
