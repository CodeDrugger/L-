package lab2;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;

import lab2.service.DisplayService;

public class AllBook implements Action {
	private ArrayList<Object> list;
	
	public ArrayList<Object> getList() {
		return list;
	}
	public void setList(ArrayList<Object> list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {
		DisplayService ds = new DisplayService();
		setList(ds.Dispaly(1));
		if (getList().size() == 0)			
			return ERROR;
		else
			return SUCCESS;
	}

}
