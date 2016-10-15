package lab2;

import com.opensymphony.xwork2.Action;

public class AddRow implements Action {
	private String note;
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String execute() throws Exception {
		setNote(" ");
		return SUCCESS;
	}

}
